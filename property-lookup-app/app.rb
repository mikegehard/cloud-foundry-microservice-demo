require 'rubygems'
require 'bundler/setup'
require 'sinatra'
require 'service_locator/load_balancer_client'

get '/' do
  # Pull this from an environment variable for a bound, user defined service.
  service_locator_address = "http://host-of-your-eureka-setup:1234"

  load_balancer = ServiceLocator::LoadBalancerClient.new(service_locator_address)
  service_instance = load_balancer.get("PROPERTY LOOKUP")

  "http://#{service_instance.address}:#{service_instance.port}"
end