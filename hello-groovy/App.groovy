@Grab('org.springframework.data:spring-data-hadoop:2.0.2.RELEASE-hadoop24')

import org.apache.hadoop.fs.FileStatus
import org.springframework.data.hadoop.fs.FsShell

public class App implements CommandLineRunner {

	@Autowired FsShell fsShell

	void run(String... args) {
		println("Hello!")
		for (FileStatus fs : fsShell.ls("/")) {
			println("> ${fs.path.name}")
		}
	}

	@Bean FsShell fsShell() {
		org.apache.hadoop.conf.Configuration conf = 
			new org.apache.hadoop.conf.Configuration()
		conf.set("fs.defaultFS", "hdfs://borneo:8020")
		return new FsShell(conf)
	}

}