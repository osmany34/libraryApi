# libraryAPI

Bu proje, Kütüphane Yönetim Sistemi için bir REST API'dir.

## Endpointler

### Author Endpoints

- **POST /v1/authors**
   - Açıklama: Yeni bir yazar ekler.

- **GET /v1/authors/{id}**
   - Açıklama: Belirtilen id ile yazarı getirir.

- **PUT /v1/authors**
   - Açıklama: Mevcut bir yazarı günceller.

- **DELETE /v1/authors/{id}**
   - Açıklama: Belirtilen id ile yazarı siler.

### Book Endpoints

- **POST /v1/books**
   - Açıklama: Yeni bir kitap ekler.

- **GET /v1/books/{id}**
   - Açıklama: Belirtilen id ile kitabı getirir.

- **PUT /v1/books**
   - Açıklama: Mevcut bir kitabı günceller.

- **DELETE /v1/books/{id}**
   - Açıklama: Belirtilen id ile kitabı siler.

### Category Endpoints

- **POST /v1/categories**
   - Açıklama: Yeni bir kategori ekler.

- **GET /v1/categories/{id}**
   - Açıklama: Belirtilen id ile kategoriyi getirir.

- **PUT /v1/categories**
   - Açıklama: Mevcut bir kategoriyi günceller.

- **DELETE /v1/categories/{id}**
   - Açıklama: Belirtilen id ile kategoriyi siler (Kitap varsa silinmez).

### Publisher Endpoints

- **POST /v1/publishers**
   - Açıklama: Yeni bir yayınevi ekler.

- **GET /v1/publishers/{id}**
   - Açıklama: Belirtilen id ile yayınevini getirir.

- **PUT /v1/publishers**
   - Açıklama: Mevcut bir yayınevini günceller.

- **DELETE /v1/publishers/{id}**
   - Açıklama: Belirtilen id ile yayınevini siler.

### Book Borrowing Endpoints

- **POST /v1/bookborrowings**
   - Açıklama: Yeni bir kitap ödünç alma kaydı ekler.

- **GET /v1/bookborrowings/{id}**
   - Açıklama: Belirtilen id ile ödünç alma kaydını getirir.

- **PUT /v1/bookborrowings**
   - Açıklama: Mevcut bir ödünç alma kaydını günceller.

- **DELETE /v1/bookborrowings/{id}**
   - Açıklama: Belirtilen id ile ödünç alma kaydını siler.


## Bağımlılıklar

- Spring Boot
- Spring Data JPA
- Lombok
- ModelMapper
- PostgreSQL
