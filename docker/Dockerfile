FROM alpine:3.7
ADD ./rs-build ./rs-exec /usr/local/bin/
RUN /usr/local/bin/rs-build
ADD ./supervisor.d /etc/supervisor.d/
CMD ["/usr/local/bin/rs-exec"]
