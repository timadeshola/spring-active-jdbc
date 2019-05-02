# spring-active-jdbc
Spring boot project using ACTIVE JDBC

Add the below dependency and pluggin to enable active jdbc

        <dependency>
			<groupId>org.javalite</groupId>
			<artifactId>activejdbc</artifactId>
			<version>2.2</version>
		</dependency>
		
		<plugin>
            <groupId>org.javalite</groupId>
            <artifactId>activejdbc-instrumentation</artifactId>
            <version>2.2</version>
            <executions>
                <execution>
                    <phase>process-classes</phase>
                    <goals>
                        <goal>instrument</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
        
Run the below maven command to build the project
* mvn activejdbc-instrumentation:instrument      
* mvn process-classes


