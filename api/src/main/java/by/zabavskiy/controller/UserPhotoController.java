package by.zabavskiy.controller;

import by.zabavskiy.domain.User;
import by.zabavskiy.exception.EntityNotFoundException;
import by.zabavskiy.photos.AmazonUploadFileService;
import by.zabavskiy.repository.impl.UserSpringDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/rest/photos/user")
@RequiredArgsConstructor
public class UserPhotoController {

    //access to Repository without service layer
    private final UserSpringDataRepository userSpringDataRepository;

    private final AmazonUploadFileService amazonUploadFileService;

    @PostMapping("/{id}")
    public ResponseEntity<Map<Object, Object>> uploadUserPhoto(@PathVariable Long id,
                                                               @RequestBody MultipartFile file) throws IOException {

        User user = userSpringDataRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        byte[] imageBytes = file.getBytes();
        String imageLink = amazonUploadFileService.uploadFile(imageBytes, id);

        user.setPhotoLink(imageLink);
        userSpringDataRepository.save(user);

        return new ResponseEntity<>(Collections.singletonMap("imageLink", imageLink), HttpStatus.CREATED);
    }

}
