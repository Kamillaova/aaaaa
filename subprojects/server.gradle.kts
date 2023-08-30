dependencies {
	implementation("cat.inspiracio:rhino-js-engine:1.7.7.1")

	api(libs.netty.buffer)
	api(libs.netty.codec)
	api(libs.netty.handler)
	api(libs.netty.transport)
	api(libs.netty.transport.epoll.classes)
	api(libs.netty.transport.epoll.native) { artifact { classifier = "linux-x86_64" } }

	api(libs.log4j.api)
	implementation(libs.log4j.core)
	annotationProcessor(libs.log4j.core)
	implementation(libs.log4j.iostreams)
	implementation(libs.log4j.slf4j.impl)
	runtimeOnly(libs.disruptor)
	implementation(libs.slf4j.api)
	implementation(libs.terminalconsoleappender)
	runtimeOnly(libs.jline.terminal.jansi)

	implementation("org.apache.logging.log4j:log4j-bom:2.20.0")
	implementation(project(":purpur-api"))
	implementation("com.destroystokyo.paper:paper-mojangapi:1.16.5-R0.1-SNAPSHOT")
	implementation("dev.kamillaova.paper:minecraft-server:1.16.5-SNAPSHOT")
	implementation("com.mojang:datafixerupper:5.0.28") {
		exclude(group = "org.slf4j", module = "slf4j-api")
	}
	implementation("com.mojang:authlib:2.3.31")
	implementation("it.unimi.dsi:fastutil:8.5.12")
	implementation("org.apache.commons:commons-lang3:3.13.0")
	implementation("commons-io:commons-io:2.13.0")
	implementation("commons-codec:commons-codec:1.16.0")
	implementation("net.sf.jopt-simple:jopt-simple:6.0-alpha-3")
	implementation("org.ow2.asm:asm:9.5")
	implementation("co.aikar:cleaner:1.0-SNAPSHOT")
	implementation("com.googlecode.json-simple:json-simple:1.1.1")
	implementation("org.xerial:sqlite-jdbc:3.42.0.1")
	implementation("com.mysql:mysql-connector-j:8.1.0")
	implementation("org.apache.maven:maven-resolver-provider:3.9.4")
	implementation("org.apache.maven.resolver:maven-resolver-impl:1.9.15")
	implementation("org.apache.maven.resolver:maven-resolver-connector-basic:1.9.15")
	implementation("org.apache.maven.resolver:maven-resolver-transport-http:1.9.15")
	implementation("com.velocitypowered:velocity-native:3.1.1")

	testImplementation("io.github.classgraph:classgraph:4.8.162")

	constraints {
		implementation(libs.jline.reader)
	}
}
