module ServiceLocator
  class ServiceInstance
    attr_reader :host, :port

    def initialize(host, port)
      @host = host
      @port = port
    end
  end
end