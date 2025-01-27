# Configuring Bean

Learned how to configure a 3rd party class and exposes it as a bean

A demo example of configuring an S3Client

```java
import // bla bla

@Configuration
public class DocumentsConfig {
	@Bean
	public S3Client remoteClient(){
		ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create();
		Region region = Region.US_EAST_1;
		S3Client s3Client = s3Client.builder().region(regsion).credentialProvider(CredentialProvider).build()
	return s3Client;
	}
}
```

now we can inject the S3Client as bean into our application

```java
import // bla bla

@Component
public class DocumentsService {
	private S3Client s3Client;


	@Autowired
	public DocumentsService (S3Client theS3Client){
		s3Client = theS3Client;
	}
}
```
