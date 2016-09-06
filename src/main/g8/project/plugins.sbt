resolvers ++= Seq(
	Resolver.typesafeRepo("releases"),
	Resolver.sonatypeRepo("public")
)

// Scalastyle usage http://www.scalastyle.org/sbt.html
addSbtPlugin("org.scalastyle"     %% "scalastyle-sbt-plugin"   % "0.8.0")

// https://github.com/sbt/sbt-release
addSbtPlugin("com.github.gseitz"  %% "sbt-release"             % "1.0.0")

// Scalariform (https://github.com/sbt/sbt-scalariform)
addSbtPlugin("com.typesafe.sbt"   %  "sbt-scalariform"         % "1.3.0")

// sbt-buildinfo (https://github.com/sbt/sbt-buildinfo)
addSbtPlugin("com.eed3si9n"       %  "sbt-buildinfo"           % "0.2.5")
