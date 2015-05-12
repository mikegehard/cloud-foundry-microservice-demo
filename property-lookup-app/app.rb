require 'rubygems'
require 'bundler/setup'
require 'sinatra'
require 'service_locator/load_balancer_client'

get '/' do
  # TODO: Pull this from an environment variable for a bound, user defined service.
  service_locator_address = URI("http://service-discovery.192.168.11.11.xip.io")

  load_balancer = ServiceLocator::LoadBalancerClient.new(service_locator_address)
  service_instance = load_balancer.get("PROPERTY LOOKUP")

  Net::HTTP.get(URI.parse("http://#{service_instance.host}:#{service_instance.port}"))
end