#!/usr/bin/env ruby

def has_all_divisors?(num, divisors)
	divisors.all? {|divisor| 0 == num % divisor}
end

start = Time.now
i = 1
until has_all_divisors?(i, 2..20)
	i += 1
end
puts i
puts "Elapsed time: #{Time.now - start} msecs"
