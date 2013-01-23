
task :default do
	Dir["./src/euler/*.clj"].sort.each do |problem_file|
		system "clj #{problem_file}"
	end
end
