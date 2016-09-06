import sbt._

object Dependencies {

	object Versions {
		val logback         = "1.1.5"
		val scalaLogging    = "3.4.0"
		val config          = "1.3.0"
		val scalatest       = "3.0.0"
		val scalamock       = "3.2.2"
		val mockito         = "1.10.19"
		val scalacheck      = "1.13.2"
	}

	// Despegar Repositories
	val repositories 	    = Seq(
		Resolver.typesafeRepo("releases"),
		Resolver.sonatypeRepo("public")
	)
	
	// Dependencies
	val projectDependencies = Seq(
		"ch.qos.logback"              %  "logback-classic"      % Versions.logback          % "runtime",
		"com.typesafe.scala-logging"  %% "scala-logging"        % Versions.scalaLogging,
		"com.typesafe"                %  "config"               % Versions.config,
		"org.scalatest"               %% "scalatest"            % Versions.scalatest        % "test",
		"org.scalamock"               %% "scalamock-scalatest-support" % Versions.scalamock % "test",
		"org.mockito"                 %  "mockito-all"          % Versions.mockito          % "test",
		"org.scalacheck" 			  %% "scalacheck" 			% Versions.scalacheck
	)	
}
