package writeQueue.wqDemo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface payloadRepo extends MongoRepository<payloadReception, String> {}

