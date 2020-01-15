-- MariaDB dump 10.17  Distrib 10.4.8-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	10.4.8-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_author`
--

DROP TABLE IF EXISTS `tbl_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_author` (
  `authorId` int(11) NOT NULL AUTO_INCREMENT,
  `authorName` varchar(45) NOT NULL,
  PRIMARY KEY (`authorId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_author`
--

LOCK TABLES `tbl_author` WRITE;
/*!40000 ALTER TABLE `tbl_author` DISABLE KEYS */;
INSERT INTO `tbl_author` VALUES (1,'Mia Vieyra'),(2,'Flo Blakemore'),(3,'Duke Guyver'),(4,'Megen Rodrigues'),(5,'Georas Petlyura'),(6,'Adan Gregon'),(7,'Madlen Episcopio'),(8,'Alasteir Lintill'),(9,'Garrik Fitzsymon'),(10,'Ian Iskowicz'),(11,'Raf Lambirth'),(12,'Pier Leaney'),(13,'Minna Luppitt'),(14,'Friedrick Dupree'),(15,'Malissia Mandal'),(16,'Kristo Jonathon'),(17,'Nettle Kelbie'),(18,'Raina Bauman'),(19,'Michaella Campelli'),(20,'Shina Glendenning');
/*!40000 ALTER TABLE `tbl_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_book`
--

DROP TABLE IF EXISTS `tbl_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `pubId` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  KEY `fk_publisher` (`pubId`),
  CONSTRAINT `fk_publisher` FOREIGN KEY (`pubId`) REFERENCES `tbl_publisher` (`publisherId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_book`
--

LOCK TABLES `tbl_book` WRITE;
/*!40000 ALTER TABLE `tbl_book` DISABLE KEYS */;
INSERT INTO `tbl_book` VALUES (1,'The Adventurers',1),(2,'To Mars by A-Bomb',2),(3,'Starman',3),(4,'Town That Dreaded Sundown, The',4),(5,'That Man from Rio',5),(6,'Brooklyn Bridge',6),(7,'Wake Island',7),(8,'Tentacles (Tentacoli)',8),(9,'The Night Evelyn Came Out of the Grave',9),(10,'Christmas in Conway',10),(11,'Coquette',11),(12,'Soap and Water',12),(13,'Lola (Twinky) (London Affair)',13),(14,'Vertigo',14),(15,'The... Beautiful Country',15),(16,'The Beaver Trilogy',16),(17,'Anthropophagus: The Grim Reaper',17),(18,'Azur & Asmar (Azur et Asmar)',18),(19,'Indiana Jones: Kingdom of the Crystal Skull',19),(20,'Dream of Light (a.k.a. Quince Tree Sun, The)',20);
/*!40000 ALTER TABLE `tbl_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_book_authors`
--

DROP TABLE IF EXISTS `tbl_book_authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_book_authors` (
  `bookId` int(11) NOT NULL,
  `authorId` int(11) NOT NULL,
  PRIMARY KEY (`bookId`,`authorId`),
  KEY `fk_tbl_book_authors_tbl_author1_idx` (`authorId`),
  CONSTRAINT `fk_tbl_book_authors_tbl_author1` FOREIGN KEY (`authorId`) REFERENCES `tbl_author` (`authorId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_book_authors_tbl_book1` FOREIGN KEY (`bookId`) REFERENCES `tbl_book` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_book_authors`
--

LOCK TABLES `tbl_book_authors` WRITE;
/*!40000 ALTER TABLE `tbl_book_authors` DISABLE KEYS */;
INSERT INTO `tbl_book_authors` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20);
/*!40000 ALTER TABLE `tbl_book_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_book_copies`
--

DROP TABLE IF EXISTS `tbl_book_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_book_copies` (
  `bookId` int(11) NOT NULL,
  `branchId` int(11) NOT NULL,
  `noOfCopies` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`,`branchId`),
  KEY `fk_bc_book` (`bookId`),
  KEY `fk_bc_branch` (`branchId`),
  CONSTRAINT `fk_bc_book` FOREIGN KEY (`bookId`) REFERENCES `tbl_book` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bc_branch` FOREIGN KEY (`branchId`) REFERENCES `tbl_library_branch` (`branchId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_book_copies`
--

LOCK TABLES `tbl_book_copies` WRITE;
/*!40000 ALTER TABLE `tbl_book_copies` DISABLE KEYS */;
INSERT INTO `tbl_book_copies` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,1),(5,5,2),(6,6,3),(7,7,1),(8,8,2),(9,9,3),(10,10,1),(11,11,2),(12,12,3),(13,13,1),(14,14,2),(15,15,3),(16,16,1),(17,17,2),(18,18,3),(19,19,1),(20,20,2);
/*!40000 ALTER TABLE `tbl_book_copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_book_genres`
--

DROP TABLE IF EXISTS `tbl_book_genres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_book_genres` (
  `genre_id` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  PRIMARY KEY (`genre_id`,`bookId`),
  KEY `fk_tbl_book_genres_tbl_book1_idx` (`bookId`),
  CONSTRAINT `fk_tbl_book_genres_tbl_book1` FOREIGN KEY (`bookId`) REFERENCES `tbl_book` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_book_genres_tbl_genre1` FOREIGN KEY (`genre_id`) REFERENCES `tbl_genre` (`genre_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_book_genres`
--

LOCK TABLES `tbl_book_genres` WRITE;
/*!40000 ALTER TABLE `tbl_book_genres` DISABLE KEYS */;
INSERT INTO `tbl_book_genres` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10),(11,11),(12,12),(13,13),(14,14),(15,15),(16,16),(17,17),(18,18),(19,19),(20,20);
/*!40000 ALTER TABLE `tbl_book_genres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_book_loans`
--

DROP TABLE IF EXISTS `tbl_book_loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_book_loans` (
  `bookId` int(11) NOT NULL,
  `branchId` int(11) NOT NULL,
  `cardNo` int(11) NOT NULL,
  `dateOut` datetime DEFAULT NULL,
  `dueDate` datetime DEFAULT NULL,
  `dateIn` datetime DEFAULT NULL,
  PRIMARY KEY (`bookId`,`branchId`,`cardNo`),
  KEY `fk_bl_book` (`bookId`),
  KEY `fk_bl_branch` (`branchId`),
  KEY `fk_bl_borrower` (`cardNo`),
  CONSTRAINT `fk_bl_book` FOREIGN KEY (`bookId`) REFERENCES `tbl_book` (`bookId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bl_borrower` FOREIGN KEY (`cardNo`) REFERENCES `tbl_borrower` (`cardNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_bl_branch` FOREIGN KEY (`branchId`) REFERENCES `tbl_library_branch` (`branchId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_book_loans`
--

LOCK TABLES `tbl_book_loans` WRITE;
/*!40000 ALTER TABLE `tbl_book_loans` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_book_loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_borrower`
--

DROP TABLE IF EXISTS `tbl_borrower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_borrower` (
  `cardNo` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cardNo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_borrower`
--

LOCK TABLES `tbl_borrower` WRITE;
/*!40000 ALTER TABLE `tbl_borrower` DISABLE KEYS */;
INSERT INTO `tbl_borrower` VALUES (1,'Ekaterina Balharry','36615 Ronald Regan Street','938-112-0988'),(2,'George Thickpenny','088 American Ash Pass','581-525-6469'),(3,'Massimiliano Christin','87 Kedzie Avenue','735-616-0329'),(4,'Lowrance Lansley','45951 Dahle Street','340-163-4291'),(5,'Sigismond Simmans','29 Muir Road','922-442-6612'),(6,'Elmore Locke','4780 Messerschmidt Alley','222-722-9853'),(7,'Barbee Markushkin','27 Kennedy Alley','777-646-2944'),(8,'Ashley Leader','5327 Oakridge Road','493-572-4693'),(9,'Sherilyn Dunkerley','9 Darwin Way','535-827-3585'),(10,'Lesya Priter','18 Sycamore Place','133-375-9212'),(11,'Smith Bartelli','01968 Eagle Crest Junction','814-821-7085'),(12,'Cammie Bayman','1210 Sage Court','377-171-6937'),(13,'Sam Huggins','0 Paget Trail','311-158-6137'),(14,'Dagny Featherstone','485 Burrows Lane','471-516-2229'),(15,'Vanya Streetfield','33 Twin Pines Avenue','528-597-6583'),(16,'Benny Roglieri','67449 Algoma Court','561-230-8764'),(17,'Margalit Huggill','5 Anniversary Crossing','672-761-8200'),(18,'Killie Muino','560 Del Sol Alley','681-243-4074'),(19,'Felic Chesterman','6 Sommers Crossing','208-949-4404'),(20,'Melicent Writer','4 Rutledge Terrace','816-195-0585');
/*!40000 ALTER TABLE `tbl_borrower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_genre`
--

DROP TABLE IF EXISTS `tbl_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_genre` (
  `genre_id` int(11) NOT NULL AUTO_INCREMENT,
  `genre_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`genre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_genre`
--

LOCK TABLES `tbl_genre` WRITE;
/*!40000 ALTER TABLE `tbl_genre` DISABLE KEYS */;
INSERT INTO `tbl_genre` VALUES (1,'Comedy|Drama|Fantasy|Romance'),(2,'Drama'),(3,'Drama|Film-Noir|Thriller'),(4,'Sci-Fi'),(5,'Drama'),(6,'Comedy|Horror'),(7,'Action|Crime'),(8,'Adventure|Children|Comedy|Fantasy'),(9,'Drama'),(10,'Comedy|Crime|Thriller'),(11,'Comedy|Drama|Romance'),(12,'Comedy|Romance'),(13,'Documentary'),(14,'Comedy'),(15,'Drama|Horror|Mystery|Thriller'),(16,'Drama|Thriller'),(17,'Drama|Thriller'),(18,'Drama'),(19,'Action|Comedy|Crime|Thriller'),(20,'Comedy');
/*!40000 ALTER TABLE `tbl_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_library_branch`
--

DROP TABLE IF EXISTS `tbl_library_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_library_branch` (
  `branchId` int(11) NOT NULL AUTO_INCREMENT,
  `branchName` varchar(45) DEFAULT NULL,
  `branchAddress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`branchId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_library_branch`
--

LOCK TABLES `tbl_library_branch` WRITE;
/*!40000 ALTER TABLE `tbl_library_branch` DISABLE KEYS */;
INSERT INTO `tbl_library_branch` VALUES (1,'Frostburg State University','2417 Summit Point'),(2,'Rhode Island School of Design','2286 Boyd Way'),(3,'University of Nebraska - Lincoln','7192 Morningstar Circle'),(4,'Syrian Virtual University','75 Pond Alley'),(5,'Dokkyo University School of Medicine','3 Summit Point'),(6,'Free University of Bozen','7100 Spohn Park'),(7,'Hartford College for Women','7 Prairie Rose Point'),(8,'Narsee Monjee Institute of Management Studies','7 David Junction'),(9,'Mendeleev University of Chemical Technology','30842 Buell Terrace'),(10,'Doho University','547 Forest Lane'),(11,'Central University College','9 High Crossing Crossing'),(12,'Kandahar University','86 Jay Street'),(13,'Gwangju Catholic College','292 Talisman Pass'),(14,'Politécnico Columbiano \"Jaime Isaza Cadavid\"','73267 Melrose Lane'),(15,'Trinity Christian College','968 Dottie Trail'),(16,'China youth college for political science','9 Texas Street'),(17,'University of Occupational Health, Japan','573 Clarendon Hill'),(18,'Sevastopol National Technical University','6716 Claremont Way'),(19,'Politeknik Negeri Malang','89 Schlimgen Hill'),(20,'Harris-Stowe State University','0 Loftsgordon Pass');
/*!40000 ALTER TABLE `tbl_library_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_publisher`
--

DROP TABLE IF EXISTS `tbl_publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_publisher` (
  `publisherId` int(11) NOT NULL AUTO_INCREMENT,
  `publisherName` varchar(45) NOT NULL,
  `publisherAddress` varchar(45) DEFAULT NULL,
  `publisherPhone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`publisherId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_publisher`
--

LOCK TABLES `tbl_publisher` WRITE;
/*!40000 ALTER TABLE `tbl_publisher` DISABLE KEYS */;
INSERT INTO `tbl_publisher` VALUES (1,'Carter, Homenick and Lebsack','76582 Montana Lane','194-165-8624'),(2,'Ritchie and Sons','1 Gina Place','998-860-8908'),(3,'Hermann, Marks and Herman','2 Lotheville Court','709-443-0329'),(4,'Mueller, Collins and Barton','2059 Little Fleur Crossing','578-857-1803'),(5,'Dooley LLC','74313 Huxley Center','311-283-3420'),(6,'Wuckert LLC','2 Quincy Drive','174-215-4204'),(7,'West-Wolff','730 Service Street','760-967-9166'),(8,'Wunsch, Mann and Feest','3 Stuart Place','168-230-8011'),(9,'Graham-Schmeler','9358 Waxwing Place','717-394-9940'),(10,'Mueller and Sons','408 5th Road','169-387-0015'),(11,'DuBuque Group','31651 Ilene Drive','501-302-1068'),(12,'Gorczany-Schultz','054 Menomonie Alley','199-196-4259'),(13,'Yundt-Mueller','40 Fairview Circle','192-363-1757'),(14,'Hammes-Lubowitz','3 Ryan Junction','245-431-7390'),(15,'Rogahn and Sons','39 Superior Terrace','390-797-0804'),(16,'Hammes and Sons','82 Spohn Alley','777-203-1536'),(17,'Botsford-Ebert','7 Chive Drive','885-366-9280'),(18,'Baumbach, McClure and Rodriguez','73 Dayton Terrace','327-679-6419'),(19,'Wolf-Bayer','26201 Farwell Plaza','890-685-8385'),(20,'Mante LLC','8134 Service Place','798-111-6214');
/*!40000 ALTER TABLE `tbl_publisher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-14 20:31:16
