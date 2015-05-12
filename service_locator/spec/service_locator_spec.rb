require 'spec_helper'
require 'webmock/rspec'

require 'service_locator/load_balancer_client'

describe ServiceLocator do
  it 'can get an instance of a service from a name' do
    discovery_service_location = "http://service-discovery-server.example.com:9999"
    stub_request(:get, "#{discovery_service_location}/eureka/apps").to_return(
            :body => File.new('spec/fixtures/eureka_app_response_single_instance.xml'),
            :status => 200
        )

    uri = URI.parse(discovery_service_location)

    load_balancer_client = ServiceLocator::LoadBalancerClient.new(uri)

    serivce_instance = load_balancer_client.get("PROPERTY LOOKUP")

    expect(serivce_instance.host).to eq("192.168.11.11")
    expect(serivce_instance.port).to eq(61006)
  end
end
