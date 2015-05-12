require 'service_locator/service_instance'

require 'nokogiri'

module ServiceLocator
  class LoadBalancerClient
    def initialize(service_uri)
      @service_uri = service_uri
    end

    def get(serivce_name)
      uri = @service_uri.dup
      uri.path = "/eureka/apps"
      response = Net::HTTP.get(uri)

      response_xml = Nokogiri::XML(response)


      application = response_xml.at_xpath("//application[name = \"#{serivce_name}\"]")

      ServiceInstance.new(
          application.at_xpath("instance/hostName").content,
          application.at_xpath("instance/port").content.to_i
      )
    end
  end
end