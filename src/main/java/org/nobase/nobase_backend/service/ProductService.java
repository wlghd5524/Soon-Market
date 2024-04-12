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

    public Product createProduct(String mb_id, String mb_nickname,String _title, String _des, double _price, String category, MultipartFile imageFile, String _size) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String directoryPath = this.path + "/" + LocalDateTime.now().format(formatter);  //이미지 파일을 저장할 디렉토리 이름을 오늘 날짜로 설정
        this.rootLocation = Paths.get(directoryPath).toAbsolutePath().normalize();
        String filename = storeFile(imageFile,mb_id);
        String filePath = rootLocation.resolve(filename).toString();
        Product product = new Product();
        product.setMb_nickname(mb_nickname);
        product.setMb_id(mb_id);
        product.setPd_title(_title);
        product.setPd_des(_des);
        product.setPd_price(_price);
        product.setCategories(category);
        product.setPd_img_path(filePath);
        product.setPd_upload_time(LocalDateTime.now());

        if (Objects.equals(category, "book")) {
            Book book = new Book();
            book.setBk_des(_des);
            book.setBk_title(_title);
            book.setBk_price(_price);
            book.setBk_img_path(filePath);
            book.setBk_upload_time(LocalDateTime.now());
            book.setMb_id(mb_id);
            book.setMb_nickname(mb_nickname);
            bookRepository.save(book);
        }
        if (Objects.equals(category, "clothes")) {
            Clothes clothes = new Clothes();
            clothes.setCl_des(_des);
            clothes.setCl_title(_title);
            clothes.setCl_price(_price);
            clothes.setCl_img_path(filePath);
            clothes.setCl_upload_time(LocalDateTime.now());
            clothes.setMb_id(mb_id);
            clothes.setCl_size(_size);
            clothes.setMb_nickname(mb_nickname);
            clothesRepository.save(clothes);
        }
        if (Objects.equals(category, "electronics")) {
            Elec elec = new Elec();
            elec.setEl_des(_des);
            elec.setEl_title(_title);
            elec.setEl_price(_price);
            elec.setEl_img_path(filePath);
            elec.setEl_upload_time(LocalDateTime.now());
            elec.setMb_id(mb_id);
            elec.setMb_nickname(mb_nickname);
            elecRepository.save(elec);
        }
        if (Objects.equals(category, "etc")) {
            Etc etc = new Etc();
            etc.setEt_des(_des);
            etc.setEt_title(_title);
            etc.setEt_price(_price);
            etc.setEt_img_path(filePath);
            etc.setEt_upload_time(LocalDateTime.now());
            etc.setMb_id(mb_id);
            etc.setMb_nickname(mb_nickname);
            etcRepository.save(etc);
        }
        if (Objects.equals(category, "gift")) {
            Gift gift = new Gift();
            gift.setGf_des(_des);
            gift.setGf_title(_title);
            gift.setGf_price(_price);
            gift.setGf_img_path(filePath);
            gift.setGf_upload_time(LocalDateTime.now());
            gift.setMb_id(mb_id);
            gift.setMb_nickname(mb_nickname);
            giftRepository.save(gift);
        }
        if (Objects.equals(category, "lifegoods")) {
            LifeGoods lifeGoods = new LifeGoods();
            lifeGoods.setLg_des(_des);
            lifeGoods.setLg_title(_title);
            lifeGoods.setLg_price(_price);
            lifeGoods.setLg_img_path(filePath);
            lifeGoods.setLg_upload_time(LocalDateTime.now());
            lifeGoods.setMb_id(mb_id);
            lifeGoods.setMb_nickname(mb_nickname);
            lifegoodsRepository.save(lifeGoods);
        }
        if (Objects.equals(category, "shoes")) {
            Shoes shoes = new Shoes();
            shoes.setSh_des(_des);
            shoes.setSh_title(_title);
            shoes.setSh_price(_price);
            shoes.setSh_img_path(filePath);
            shoes.setSh_upload_time(LocalDateTime.now());
            shoes.setMb_id(mb_id);
            shoes.setSh_size(_size);
            shoes.setMb_nickname(mb_nickname);
            shoesRepository.save(shoes);
        }
        return productRepository.save(product);
    }

    public String storeFile(MultipartFile file, String mb_id) throws IOException {
        String filename = generateFileName(file,mb_id);  //파일 이름 생성(mb_id_20240401_133340.png)
        Files.createDirectories(rootLocation);
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        return filename;
    }

    public String generateFileName(MultipartFile file, String mb_id) {
        String filename = file.getOriginalFilename();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        int dotIndex = filename.lastIndexOf('.');  //파일 확장자 파싱
        if (dotIndex < 0) {
            return null;
        }
        String extension = filename.substring(dotIndex);
        filename = mb_id + "_" + formattedDateTime + extension;
        return filename;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}


