# Conflict Шийдвэрлэлт

## Conflict-ийн Дэлгэрэнгүй

`feature/add-multiply-validation` салбарыг `develop` руу нэгтгэхэд merge conflict үүссэн:
- **Файл**: `src/main/java/labxx/sict/must/edu/mn/Multiplication.java`
- **Байршил**: Multiplication классын Javadoc коммент
- **Шалтгаан**: Хоёр branch ижил мөрийг өөр өөр утгаар өөрчилсөн

## Шийдвэрлэлтийн Алхмууд

### 1. Merge-ийг өөрчлөх
```bash
git checkout feature/add-multiply-validation
git merge develop
```

### 2. Conflict-ийг тодорхойлох
Git дараах мессежийг харуулсан:
```
Auto-merging src/main/java/labxx/sict/must/edu/mn/Multiplication.java
CONFLICT (content): Merge conflict in Multiplication.java
Automatic merge failed; fix conflicts and then commit the result.
```

### 3. Зөрчилтэй файлыг нээх
Файлыг засварлагч дээр нээхэд conflict marker-ууд харагдсан:
```java
/**
 * Multiplication calculator with validation support.
 */
/**
 * Multiplication calculator for numeric operations.
 */
```

**Хоёр хувилбар**:
- `HEAD` (feature/add-multiply-validation): "Multiplication calculator with validation support"
- `develop`: "Multiplication calculator for numeric operations"

### 4. Conflict-ийг шийдвэрлэх
Хоёр тайлбарыг утга учиртай нэгтгэж, эцсийн хувилбарыг бичсэн:
```java
/**
 * Multiplication calculator for numeric operations with validation support.
 */
```

Бүх conflict marker-уудыг (`<<<<<<<`, `=======`, `>>>>>>>`) устгасан.

### 5. Янзалсан файлыг stage хийх
```bash
git add src/main/java/labxx/sict/must/edu/mn/Multiplication.java
```

### 6. Merge хийж дуусгах
```bash
git commit -m "Resolve merge conflict in Multiplication.java Javadoc"
```

### 7. Засварлалтыг баталгаажуулах
Бүх шалгалтыг ажиллуулж амжилттай болохыг баталгаажуулсан:
```bash
mvn clean test
mvn checkstyle:check
mvn jacoco:report
```

Үр дүн:
- ✅ Бүх тест амжилттай
- ✅ Checkstyle алдаагүй
- ✅ 100% branch coverage хангагдсан

### 8. Өөрчлөлтийг push хийх
```bash
git push origin feature/add-multiply-validation
```

### 9. Pull Request үүсгэх
GitHub дээр `feature/add-multiply-validation` → `develop` руу PR үүсгэж, CI шалгалтууд амжилттай явагдсаныг хүлээсэн.

## Conflict-ийн Шийдэл

**Өмнөх байдал** (хоёр өөр хувилбар):
- Feature салбар: "with validation support"
- Develop салбар: "for numeric operations"

**Шийдсэн байдал** (нэгдсэн хувилбар):
- "for numeric operations with validation support"

Энэ нь хоёр branch-ийн санаануудыг бүрэн тусгасан бөгөөд кодын агуулгад нийцсэн.

## Хийж сурсан зүйлс

1. **Тогтмол харилцаа холбоо чухал**: Багийн гишүүд ижил файл дээр ажиллаж байгаа эсэхийг мэдэх нь давхцлыг багасгана.

2. **Байнга шинэчлэлт буюу pull татах**: `git pull origin develop` командыг тогтмол ажиллуулах нь том conflict-ийг урьдчилан сэргийлнэ.

3. **Утга бүхий commit мессеж**: Тодорхой commit мессеж нь conflict-ийн контекстийг ойлгоход тусалдаг.

4. **Шийдвэрлэлтийн дараа шалгах**: Conflict шийдсэний дараа заавал test, checkstyle, coverage шалгалтуудыг ажиллуулж, алдаа гараагүй эсэхийг баталгаажуулах.

5. **Conflict marker-уудыг бүрэн устгах**: `<<<<<<<`, `=======`, `>>>>>>>` тэмдэглэгээнүүд кодонд үлдээвэл алдаа гарна.

## Ашигласан Git Командууд

```bash
# Branch солих
git checkout feature/add-multiply-validation

# Develop branch-г нэгтгэх оролдлого хийх
git merge develop

# Conflict-тэй файлын статусыг харах
git status

# Шийдэгдсэн файлыг нэмэх
git add src/main/java/labxx/sict/must/edu/mn/Multiplication.java

# Merge commit үүсгэх
git commit -m "Resolve merge conflict in Multiplication.java Javadoc"

# репозитори руу push хийх
git push origin feature/add-multiply-validation
```

## Дүгнэлт

Merge conflict нь Git workflow-ийн хэвийн хэсэг бөгөөд зөв шийдвэрлэх нь:
- Кодын бүрэн бүтэн байдлыг хадгална
- Багийн бүх гишүүдийн өөрчлөлтийг хамардаг
- Төслийн тогтвортой байдлыг баталгаажуулдаг

Энэхүү лабораторийн ажлаар ирээдүйд илүү том төслүүд дээр ажиллахад conflict-уудыг үр дүнтэй шийдвэрлэх чадвартай болсон.