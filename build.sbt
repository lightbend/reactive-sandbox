import scala.sys.process._
import ReleaseTransformations._

name := "reactive-sandbox"

TaskKey[Unit]("dockerBuildTagAndWarnAboutPublishing") := {
  val localTag = s"reactive-sandbox:${version.value}"
  val remoteTag = s"lightbend-docker-registry.bintray.io/rp/$localTag"

  val buildCommand = Vector("docker", "build", "-t", localTag, "./docker")
  val tagCommand = Vector("docker", "tag", localTag, remoteTag)

  streams.value.log.info(s"Building Docker image: $localTag")

  val buildCode = buildCommand.!

  if (buildCode != 0) {
    sys.error(s"Expected 0, received $buildCode for: $buildCommand")
  }

  streams.value.log.info(s"Tagging Docker image: $localTag with $remoteTag")

  val tagCode = tagCommand.!

  if (tagCode != 0) {
    sys.error(s"Expected 0, received $tagCode for: $tagCommand")
  }

  streams.value.log.warn("The build has been completed but the image has not been published. Consult the Platform Tooling Release Process document in Google Drive.")
  streams.value.log.warn(s"""To publish: docker push "$remoteTag"""")
}

releaseProcess := Vector[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  setReleaseVersion,
  commitReleaseVersion,
  releaseStepCommandAndRemaining("dockerBuildTagAndWarnAboutPublishing"),
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges
)
