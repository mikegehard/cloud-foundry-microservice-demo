require 'service_locator/service_instance'

module ServiceLocator
  class LoadBalancerClient
    def initialize(service_url)
    end

    def get(serivce_name)
      ServiceInstance.new("1.2.3.4", 1234)
    end
  end
end