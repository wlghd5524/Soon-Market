package org.nobase.nobase_backend.service;

import lombok.RequiredArgsConstructor;
import org.nobase.nobase_backend.entity.*;
import org.nobase.nobase_backend.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
@RequiredArgsConstructor
@Service
public class ProductService{
    @Value("${productFile.upload-dir}")
    private String path;
    private Path rootLocation;
    private final ProductRepository productRepository;
    private final BookRepository bookRepository;
    private final ClothesRepository clothesRepository;
    private final ElecRepository elecRepository;
    private final EtcRepository etcRepository;
    private final GiftRepository giftRepository;
    private final LifeGoodsRepository lifegoodsRepository;
    private final ShoesRepository shoesRepository;

    public Product createProduct(String mbId, String mbUsername,String title, String des, double price, String category, MultipartFile imageFile, String size) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String directoryPath = this.path + "/" + LocalDateTime.now().format(formatter);  //이미지 파일을 저장할 디렉토리 이름을 오늘 날짜로 설정
        this.rootLocation = Paths.get(directoryPath).toAbsolutePath().normalize();
        String filename = storeFile(imageFile,mbId);
        String filePath = rootLocation.resolve(filename).toString();
        Product product = new Product();
        product.setMbUsername(mbUsername);
        product.setMbId(mbId);
        product.setPdTitle(title);
        product.setPdDes(des);
        product.setPdPrice(price);
        product.setCategories(category);
        product.setPdImgPath(filePath);
        product.setPdUploadTime(LocalDateTime.now());

        if (Objects.equals(category, "book")) {
            Book book = new Book();
            book.setBkDes(des);
            book.setBkTitle(title);
            book.setBkPrice(price);
            book.setBkImgPath(filePath);
            book.setBkUploadTime(LocalDateTime.now());
            book.setMbId(mbId);
            book.setMbUsername(mbUsername);
            bookRepository.save(book);
        }
        if (Objects.equals(category, "clothes")) {
            Clothes clothes = new Clothes();
            clothes.setClDes(des);
            clothes.setClTitle(title);
            clothes.setClPrice(price);
            clothes.setClImgPath(filePath);
            clothes.setClUploadTime(LocalDateTime.now());
            clothes.setMbId(mbId);
            clothes.setClSize(size);
            clothes.setMbUsername(mbUsername);
            clothesRepository.save(clothes);
        }
        if (Objects.equals(category, "electronics")) {
            Elec elec = new Elec();
            elec.setElDes(des);
            elec.setElTitle(title);
            elec.setElPrice(price);
            elec.setElImgPath(filePath);
            elec.setElUploadTime(LocalDateTime.now());
            elec.setMbId(mbId);
            elec.setMbUsername(mbUsername);
            elecRepository.save(elec);
        }
        if (Objects.equals(category, "etc")) {
            Etc etc = new Etc();
            etc.setEtDes(des);
            etc.setEtTitle(title);
            etc.setEtPrice(price);
            etc.setEtImgPath(filePath);
            etc.setEtUploadTime(LocalDateTime.now());
            etc.setMbId(mbId);
            etc.setMbUsername(mbUsername);
            etcRepository.save(etc);
        }
        if (Objects.equals(category, "gift")) {
            Gift gift = new Gift();
            gift.setGfDes(des);
            gift.setGfTitle(title);
            gift.setGfPrice(price);
            gift.setGfImgPath(filePath);
            gift.setGfUploadTime(LocalDateTime.now());
            gift.setMbId(mbId);
            gift.setMbUsername(mbUsername);
            giftRepository.save(gift);
        }
        if (Objects.equals(category, "lifegoods")) {
            LifeGoods lifeGoods = new LifeGoods();
            lifeGoods.setLgDes(des);
            lifeGoods.setLgTitle(title);
            lifeGoods.setLgPrice(price);
            lifeGoods.setLgImgPath(filePath);
            lifeGoods.setLgUploadTime(LocalDateTime.now());
            lifeGoods.setMbId(mbId);
            lifeGoods.setMbUsername(mbUsername);
            lifegoodsRepository.save(lifeGoods);
        }
        if (Objects.equals(category, "shoes")) {
            Shoes shoes = new Shoes();
            shoes.setShDes(des);
            shoes.setShTitle(title);
            shoes.setShPrice(price);
            shoes.setShImgPath(filePath);
            shoes.setShUploadTime(LocalDateTime.now());
            shoes.setMbId(mbId);
            shoes.setShSize(size);
            shoes.setMbUsername(mbUsername);
            shoesRepository.save(shoes);
        }
        return productRepository.save(product);
    }

    public String storeFile(MultipartFile file, String mbId) throws IOException {
        String filename = generateFileName(file,mbId);  //파일 이름 생성(userID_20240401_133340.png)
        Files.createDirectories(rootLocation);
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    public String generateFileName(MultipartFile file, String mbId) {
        String filename = file.getOriginalFilename();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        int dotIndex = filename.lastIndexOf('.');  //파일 확장자 파싱
        if (dotIndex < 0) {
            return null;
        }
        String extension = filename.substring(dotIndex);
        filename = mbId + "_" + formattedDateTime + extension;
        return filename;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}


