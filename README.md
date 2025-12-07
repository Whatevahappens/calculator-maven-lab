# Тооны машин

Git workflow, Maven бүтээх, JUnit тест, Checkstyle, болон JaCoCo кодын coverage-г харуулсан энгийн тооны машины код.

## Лабораторийн ажлын тухай Тухай

Энэхүү ажил нь программ хангамж хөгжүүлэлтийн аргыг дагаж мөрдсөн бөгөөд:
- **Git Workflow**: Feature branch, release удирдлага, hotfix процесс
- **Maven Build**: Автомат build болон dependency management
- **JUnit 5**: Unit тестүүд
- **Checkstyle**: Кодын загварын шалгалт
- **JaCoCo**: 100% branch coverage-тэй код Coverage шинжилгээ
- **GitHub Actions**: Тасралтгүй интеграцийн (CI) pipeline

## Ажиллуулах

### Шаардлагатай хувилбарууд

Дараах хувилбаруудыг ашиглана:
- **Java**: 17 эсвэл түүнээс дээш хувилбар
- **Maven**: 3.6 эсвэл түүнээс дээш хувилбар

### Java болон Maven-ийг Шалгах

```bash
# Java хувилбарыг шалгах
java -version

# Maven хувилбарыг шалгах
mvn -version
```

### Үндсэн Командууд

```bash
# Project-г цэвэрлэж, бүх dependency-г татаж авах
mvn clean install

# Тестүүдийг ажиллуулах
mvn test

# Кодын загварын шалгалт хийх
mvn checkstyle:check

# JaCoCo хамрагдлын тайлан үүсгэх
mvn jacoco:report

# Coverage тайланг харах (Windows)
start target\site\jacoco\index.html

# Coverage тайланг харах (macOS/Linux)
open target/site/jacoco/index.html

# Бүх шалгалтуудыг нэгэн зэрэг ажиллуулах
mvn clean verify
```

### Заавар

1. **Репозиторийг clone хийх**:
   ```bash
   git clone https://github.com/YOUR_USERNAME/calculator-maven-lab.git
   cd calculator-maven-lab
   ```

2. **Хамаарлуудыг татаж авах**:
   ```bash
   mvn clean install
   ```

3. **Тестүүдийг ажиллуулах**:
   ```bash
   mvn test
   ```

4. **Кодын чанарыг шалгах**:
   ```bash
   mvn checkstyle:check
   mvn jacoco:report
   ```

## Төслийн Бүтэц

```
calculator-maven-lab/
├── .github/
│   └── workflows/
│       └── ci.yml                 # GitHub Actions CI тохиргоо
├── src/
│   ├── main/
│   │   └── java/
│   │       └── labxx/sict/must/edu/mn/
│   │           ├── Multiplication.java    # Үржүүлэх функц
│   │           └── Division.java          # Хуваах функц
│   └── test/
│       └── java/
│           └── labxx/sict/must/edu/mn/
│               ├── MultiplicationTest.java   # Үржүүлэх тестүүд
│               └── DivisionTest.java         # Хуваах тестүүд
├── target/
│   └── site/
│       └── jacoco/
│           └── index.html         # Хамрагдлын тайлан
├── .gitignore                     # Git-д орхигдох файлууд
├── checkstyle.xml                 # Checkstyle тохиргоо
├── pom.xml                        # Maven тохиргоо
├── conflict_resolution.md         # Conflict шийдвэрлэлтийн баримт
└── README.md                      # Энэхүү файл
```

## Функцууд

### Multiplication (Үржүүлэх)
Хоёр тоог үржүүлж үр дүнг буцаана.

```java
Multiplication calc = new Multiplication();
double result = calc.multiply(2.0, 3.0);  // 6.0
```

### Division (Хуваах)
Хоёр тоог хуваана. Тэгээр хуваахыг зохицуулна.

```java
Division calc = new Division();
double result = calc.divide(6.0, 3.0);  // 2.0
```

## Тасралтгүй Интеграци (CI/CD)

Энэхүү Лабораторийн ажилд GitHub Actions ашиглан автоматжуулсан тасралтгүй интеграци (CI) процессыг хэрэгжүүлсэн. CI процесс нь дараахыг баталгаажуулдаг:

### Шалгалтууд

✅ **JUnit Тестүүд**: Бүх unit тестүүд амжилттай явагдсан
✅ **Checkstyle**: Код нь тогтоосон загварын дүрмүүдийг дагаж мөрдсөн  
✅ **JaCoCo Coverage**: 100% branch coverage хангагдсан

### Ажиллах Нөхцөл

CI процесс дараах үед автоматаар ажилладаг:
- `develop` branch руу push хийхэд
- `release/*` branch-ууд руу push хийхэд
- Pull request үүсгэхэд

### Branch Protection

`main` branch нь хамгаалагдсан:
- Шууд push хийх боломжгүй
- Pull request-ээр л нэгтгэх боломжтой
- CI шалгалтууд амжилттай болсон тохиолдолд л merge хийгдэнэ
- Checkstyle эсвэл 100% coverage хангагдаагүй бол merge татгалзагдана

## Git Workflow

Project дараах Git workflow-г дагаж мөрддөг:

### Салбарууд

- **main**: Тогтвортой production branch код
- **develop**: Хөгжүүлэлтийн branch
- **feature/\***: Шинэ функцүүд (жишээ: `feature/add-multiplication`)
- **release/\***: Хувилбар гаргалт (жишээ: `release/v1.0.0`)
- **hotfix/\***: Яаралтай засвар (жишээ: `hotfix/v1.0.1`)

### Workflow Алхмууд

1. `develop` branch-аас feature branch үүсгэх
2. Функцийг хөгжүүлж, тест бичих
3. Pull request үүсгэх
4. CI шалгалтууд амжилттай болохыг хүлээх
5. Code review хийлгэх
6. `develop` руу merge хийх

## Кодын Чанарын Шаардлага

### Checkstyle Дүрэм

- Мөр бүр 120 тэмдэгтээс хэтрэхгүй байх
- Функц бүр 100 мөрөөс хэтрэхгүй байх
- 4 зай ашиглан догол мөр хийх
- Бүх нөхцөлд хаалт `{}` ашиглах

### Тестийн Шаардлага

- Функц бүрт хамгийн багадаа 2 тест кейс байх
- 100% branch coverage хангах
- Бүх алдааны нөхцөл тестлэгдсэн байх
- Тодорхой assert мессеж ашиглах

## Асуудал Шийдвэрлэлт

### Maven Хамаарлын Алдаа

Хэрэв `Dependency not found` алдаа гарвал:

```bash
# Maven cache цэвэрлэх
rm -rf ~/.m2/repository

# Хамаарлуудыг дахин татаж авах
mvn clean install -U
```

### Checkstyle Алдаа

```bash
# Дэлгэрэнгүй алдааны мэдээлэл харах
mvn checkstyle:check -e
```

### JaCoCo Coverage Хүрэхгүй Байгаа

```bash
# Хамрагдлын тайланг үүсгэж, шалгах
mvn clean test jacoco:report
start target\site\jacoco\index.html
```

Хамрагдаагүй branch-үүдийг олж, тухайн нөхцлүүдэд тест нэмэх.

## Хувилбарын Түүх

- **v1.0.0**: Анхны хувилбар - Үржүүлэх, хуваах функцүүд
- **v1.0.1**: Hotfix - Хуваах функцийн алдаа засварлалт

## Ашигласан Технологиүүд

- **Java 17**: Программчлалын хэл
- **Maven 3.x**: Төслийн удирдлага, бүтээлт
- **JUnit 5**: Unit тестийн framework
- **Checkstyle**: Кодын загварын шалгалт
- **JaCoCo**: Код хамрагдлын шинжилгээ
- **GitHub Actions**: CI/CD automation
<<<<<<< HEAD
- **Git**: Хувилбарын удирдлага
=======
- **Git**: Хувилбарын удирдлага
>>>>>>> 85c4bf1f938ecb2524194265c858817d93271fb1
