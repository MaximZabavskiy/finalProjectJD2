package by.zabavskiy.photos;

public interface AmazonUploadFileService {

    String uploadFile(byte[] image, Long userId);
}
