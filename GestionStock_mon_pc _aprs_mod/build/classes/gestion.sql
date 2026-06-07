-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 03 déc. 2023 à 15:08
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

CREATE TABLE `achat` (
  `num_bon_réception` int(255) NOT NULL DEFAULT 0,
  `date_achat` date DEFAULT NULL,
  `nom_prénom_fournisseur` varchar(255) DEFAULT NULL,
  `désignation` varchar(255) DEFAULT NULL,
  `prix_achat` double DEFAULT 0,
  `quantité` int(255) DEFAULT 0,
  `id` int(255) NOT NULL,
  `temp_achat` varchar(222) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `id_produit` int(255) DEFAULT NULL,
  `somme_versé` double NOT NULL DEFAULT 0,
  `remise` double NOT NULL DEFAULT 0,
  `prix_v_detail` double NOT NULL DEFAULT 0,
  `prix_v_gros` double NOT NULL DEFAULT 0,
  `prix_v_special` double NOT NULL DEFAULT 0,
  `idf` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`num_bon_réception`, `date_achat`, `nom_prénom_fournisseur`, `désignation`, `prix_achat`, `quantité`, `id`, `temp_achat`, `user`, `id_produit`, `somme_versé`, `remise`, `prix_v_detail`, `prix_v_gros`, `prix_v_special`, `idf`) VALUES
(332, '2023-07-23', '', 'pro4', 0, 7, 332, '10:51:50', 'admin', 140, 0, 0, 0, 0, 0, 0),
(332, '2023-07-23', '', 'pro5', 0, 5, 333, '10:51:58', 'admin', 141, 0, 0, 0, 0, 0, 0),
(332, '2023-07-23', '', 'pro7', 0, 3, 334, '10:52:11', 'admin', 143, 0, 0, 0, 0, 0, 0),
(332, '2023-07-23', '', 'p12', 2000, 4, 335, '10:52:41', 'admin', 148, 0, 0, 2000, 2000, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `catégorie_produits`
--

CREATE TABLE `catégorie_produits` (
  `id_categorie` varchar(222) NOT NULL,
  `valeur` varchar(255) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `catégorie_produits`
--

INSERT INTO `catégorie_produits` (`id_categorie`, `valeur`, `id`) VALUES
('C0', 'rrrr', 13),
('C14', 'zzzz', 14);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` varchar(100) NOT NULL,
  `nom_prénom_client` varchar(100) NOT NULL,
  `type_client` varchar(100) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `num_tel1` varchar(100) DEFAULT NULL,
  `num_tel2` varchar(100) DEFAULT NULL,
  `num_reg_commerce` varchar(100) DEFAULT NULL,
  `num_id_fiscale` varchar(100) DEFAULT NULL,
  `num_article_imposition` varchar(100) DEFAULT NULL,
  `rib_c` varchar(100) DEFAULT NULL,
  `id_c` int(100) NOT NULL,
  `crédit` double NOT NULL DEFAULT 0
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`id_client`, `nom_prénom_client`, `type_client`, `adresse`, `email`, `num_tel1`, `num_tel2`, `num_reg_commerce`, `num_id_fiscale`, `num_article_imposition`, `id_c`, `crédit`) VALUES
('C0', 'Passager', 'detail', '', '', '', '', '', '', '', '', 0, 1450),


-- --------------------------------------------------------

--
-- Structure de la table `codebarre`
--

CREATE TABLE `codebarre` (
  `id` int(11) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `code` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `codebarre`
--

INSERT INTO `codebarre` (`id`, `id_produit`, `code`) VALUES
(183, 144, '8838458234813'),
(212, 153, '6560311477654'),
(216, 154, '6130480001090'),
(222, 147, '5509982792402'),
(225, 158, '6114678234810'),
(227, 135, '4204961863547'),
(228, 146, '3462824093852'),
(229, 146, '7987546397814'),
(230, 141, '6345503859593'),
(231, 150, '5209284771056'),
(232, 150, '7471011784275'),
(233, 157, '4005900371997'),
(235, 159, '6834770055684');

-- --------------------------------------------------------

--
-- Structure de la table `couleur`
--

CREATE TABLE `couleur` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `couleur`
--

INSERT INTO `couleur` (`ID`, `valeur`) VALUES
(2, 'red'),
(3, 'black'),
(4, 'blue');

-- --------------------------------------------------------

--
-- Structure de la table `dépence`
--

CREATE TABLE `dépence` (
  `année` int(4) DEFAULT NULL,
  `mois` int(2) DEFAULT NULL,
  `depence` varchar(100) DEFAULT NULL,
  `montant` double DEFAULT 0,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `dépence`
--

INSERT INTO `dépence` (`année`, `mois`, `depence`, `montant`, `ID`) VALUES
(2020, 0, 'eau', 5555, 12),
(2020, 0, 'eau', 777, 13),
(2020, 0, 'eau', 89, 15),
(2023, 0, 'eau', 777, 16);

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE `employe` (
  `id_employe` varchar(50) NOT NULL DEFAULT '',
  `nom_prénom_employe` varchar(255) DEFAULT NULL,
  `type_employe` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `num_tel1` varchar(23) DEFAULT NULL,
  `id_e` int(222) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `employe`
--

INSERT INTO `employe` (`id_employe`, `nom_prénom_employe`, `type_employe`, `adresse`, `email`, `num_tel1`, `id_e`) VALUES
('E1', 'OMAR HA', 'ttttt', 'sds', 'sdshhh', 'sdKKK', 1),
('E2', 'KKKK', 'mmm', 'SSQSQ', 'CXVDF', '43434', 2),
('E3', 'DDDD', 'lll', 'DDDDDDDD', 'FFFFFF', '444444444444', 3),
('E4', 'NNNNNNNNNNN', 'info', 'DDDDDDDDDDDDDGGGGGGG', 'JJJJJJ', '6666666', 4);

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

CREATE TABLE `famille` (
  `valeur` varchar(50) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `famille`
--

INSERT INTO `famille` (`valeur`, `ID`) VALUES
('fam1', 11),
('fam2', 12),
('fam3', 13),
('yourourt', 15),
('lait', 16),
('diosmine', 17),
('رريعة', 18),
('pomade', 19);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id_fournisseur` varchar(100) NOT NULL,
  `nom_prenom_fournisseur` varchar(100) DEFAULT NULL,
  `entreuprise` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `adresse` varchar(100) DEFAULT NULL,
  `num_tel1` varchar(100) DEFAULT NULL,
  `num_tel2` varchar(100) DEFAULT NULL,
  `num_reg` varchar(100) DEFAULT NULL,
  `num_id_fiscale` varchar(100) DEFAULT NULL,
  `num_article_imposition` varchar(100) DEFAULT NULL,
  `rib_f` varchar(100) DEFAULT NULL,
  `id_f` int(100) NOT NULL,
  `dette` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `fournisseur`
--




-- --------------------------------------------------------

--
-- Structure de la table `images_article`
--

CREATE TABLE `images_article` (
  `image_id` int(11) NOT NULL,
  `id_produit` int(11) DEFAULT NULL,
  `imageURL` varchar(100) DEFAULT NULL,
  `principal_image` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `images_article`
--

INSERT INTO `images_article` (`image_id`, `id_produit`, `imageURL`, `principal_image`) VALUES
(1, 2, 'http://192.168.100.2/product/Images/adobe.jpg', 1),
(2, 2, 'http://192.168.100.2/product/Images/awesome.jpg', 0),
(3, 2, 'http://192.168.100.2/product/Images/iphone.jpg', 0),
(4, 1, 'http://192.168.100.2/product/Images/computer.jpg', 1),
(5, 1, 'http://192.168.100.2/product/Images/adobe.jpg', 0),
(6, 3, 'http://192.168.100.2/product/Images/sound_system.jpg', 1),
(7, 3, 'http://192.168.100.2/product/Images/stadia_gamepad.jpg', 0),
(8, 3, 'http://192.168.100.2/product/Images/adobe.jpg', 0),
(9, 3, 'http://192.168.100.2/product/Images/sofaset.jpg', 0);

-- --------------------------------------------------------

--
-- Structure de la table `inventaire`
--

CREATE TABLE `inventaire` (
  `id` int(11) NOT NULL,
  `num_inv` int(11) NOT NULL,
  `date` date NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `id_produit` int(11) NOT NULL,
  `désignation` varchar(100) NOT NULL,
  `QTE_T` float NOT NULL,
  `QTE_P` float NOT NULL,
  `Equart_qte` float NOT NULL,
  `prix_achat_ttc` double NOT NULL,
  `temp_inv` varchar(15) NOT NULL,
  `user` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `inventaire`
--

INSERT INTO `inventaire` (`id`, `num_inv`, `date`, `libelle`, `id_produit`, `désignation`, `QTE_T`, `QTE_P`, `Equart_qte`, `prix_achat_ttc`, `temp_inv`, `user`) VALUES
(1, 1, '2023-12-03', '', 135, 'pro1', 10, 3, 10, 100, '2023-12-03', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `marques`
--

CREATE TABLE `marques` (
  `valeur` varchar(50) DEFAULT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `marques`
--

INSERT INTO `marques` (`valeur`, `ID`) VALUES
('m1', 12),
('m2', 13),
('m3', 17),
('marque1', 33),
('soumam', 34),
('condia', 35),
('bellat', 37),
('adidas', 38),
('nike', 39),
('m14', 40),
('nivea', 41);

-- --------------------------------------------------------

--
-- Structure de la table `paramaitres`
--

CREATE TABLE `paramaitres` (
  `nom_magasin` varchar(255) DEFAULT NULL,
  `adresse_p` varchar(255) DEFAULT NULL,
  `num_tel_fax_fix_p` varchar(255) DEFAULT NULL,
  `num_tel1_p` varchar(255) DEFAULT NULL,
  `num_tel2_p` varchar(255) NOT NULL,
  `NIS` varchar(222) NOT NULL,
  `NRC` varchar(40) DEFAULT NULL,
  `NIF` varchar(40) DEFAULT NULL,
  `ID` int(11) NOT NULL,
  `activite` varchar(100) NOT NULL,
  `message` varchar(240) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `paramaitres`
--

INSERT INTO `paramaitres` (`nom_magasin`, `adresse_p`, `num_tel_fax_fix_p`, `num_tel1_p`, `num_tel2_p`, `NIS`, `NRC`, `NIF`, `ID`, `activite`, `message`) VALUES
('DIDI MARKET', 'boujlida', '043 21 30 34', '0000000', '1111111', '91011', '1234', '5678', 1, 'Alimentation génerale', 'Merci de votre visite');

-- --------------------------------------------------------

--
-- Structure de la table `pointure`
--

CREATE TABLE `pointure` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `pointure`
--

INSERT INTO `pointure` (`ID`, `valeur`) VALUES
(2, '39'),
(3, '40');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id_produit` int(11) NOT NULL,
  `famille` varchar(40) DEFAULT NULL,
  `unite` varchar(40) DEFAULT NULL,
  `marque` varchar(40) DEFAULT NULL,
  `image` varchar(120) DEFAULT NULL,
  `référence` varchar(20) DEFAULT NULL,
  `désignation` varchar(40) DEFAULT NULL,
  `étagére` varchar(40) DEFAULT NULL,
  `id_fournisseur` varchar(40) DEFAULT NULL,
  `remarque` varchar(222) DEFAULT NULL,
  `prix_achat` double DEFAULT 0,
  `prix_vente_detail` double DEFAULT 0,
  `prix_vente_gros` double DEFAULT 0,
  `prix_special` double DEFAULT 0,
  `quantité` float NOT NULL,
  `stock_alert` int(11) DEFAULT 0,
  `jour_alert` int(11) DEFAULT 0,
  `tva` float DEFAULT 0,
  `date_premption` date DEFAULT NULL,
  `date_achat` date DEFAULT NULL,
  `taille` varchar(10) DEFAULT NULL,
  `pointure` varchar(10) DEFAULT NULL,
  `couleur` varchar(20) DEFAULT NULL,
  `saisie_par` varchar(20) NOT NULL,
  `code_bare_packet` varchar(20) NOT NULL DEFAULT '',
  `prix_vente_packet` double NOT NULL DEFAULT 0,
  `nbre_produit_packet` int(11) NOT NULL DEFAULT 0,
  `vente_packet` tinyint(1) NOT NULL DEFAULT 0,
  `favorite` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `produit`
--

INSERT INTO `produit` (`id_produit`, `famille`, `unite`, `marque`, `image`, `référence`, `désignation`, `étagére`, `id_fournisseur`, `remarque`, `prix_achat`, `prix_vente_detail`, `prix_vente_gros`, `prix_special`, `quantité`, `stock_alert`, `jour_alert`, `tva`, `date_premption`, `date_achat`, `taille`, `pointure`, `couleur`, `saisie_par`, `code_bare_packet`, `prix_vente_packet`, `nbre_produit_packet`, `vente_packet`, `favorite`) VALUES
(135, ' ', ' ', ' ', 'src/images/image_produits/135.jpg', 'P160', 'pro1', '', '', '', 100, 130, 120, 110, 10, 3, 10, 0, NULL, '2023-09-01', '', '', '', 'admin', '', 0, 1, 0, 0),
(138, ' ', ' ', ' ', 'src/images/image_produits/138.jpg', 'P138', 'prod3', '', '', '', 0, 0, 0, 0, 8, 3, 10, 19, NULL, NULL, '', '', '', 'admin', '', 0, 0, 0, 5),
(139, ' ', ' ', ' ', 'src/images/image_produits/139.jpg', 'P160', 'pro4', '', '', '', 40, 50, 42, 45, 10, 3, 10, 19, NULL, '2023-08-30', '', '', '', 'admin', '', 0, 1, 0, 4),
(140, ' ', ' ', ' ', 'src/images/image_produits/140.jpg', 'P154', 'pro4', '', '', '', 0, 0, 0, 0, 10, 3, 10, 19, NULL, '2023-07-23', '', '', '', 'admin', '', 0, 1, 0, 0),
(141, ' ', ' ', ' ', 'src/images/image_produits/141.jpg', 'P160', 'pro5kkkklllmmmmpppoo', '', '', '', 600, 840, 720, 780, 17, 3, 10, 19, NULL, '2023-09-02', '', '', '', 'admin', '', 0, 1, 0, 3),
(144, ' ', ' ', ' ', 'src/images/image_produits/144.jpg', 'P144', 'pro8', '', '', '', 0, 0, 0, 0, 10, 3, 10, 19, NULL, '2023-07-09', '', '', '', 'admin', '', 0, 0, 0, 0),
(145, ' ', ' ', ' ', 'src/images/image_produits/145.jpg', 'P160', 'pr9', '', '', '', 20, 25, 23, 22, 10, 3, 10, 19, NULL, '2023-08-30', '', '', '', 'admin', '', 0, 1, 0, 0),
(146, ' ', ' ', ' ', 'src/images/image_produits/146.jpg', 'P160', 'p10', '', '', '', 20, 24, 23, 21, 10, 3, 10, 19, '2023-07-30', '2023-09-02', 'm', '', '', 'admin', '', 0, 1, 0, 0),
(147, ' ', ' ', ' ', 'src/images/image_produits/147.jpg', 'P160', 'pr11', '', '', '', 500, 600, 600, 600, 10, 3, 10, 19, NULL, '2023-08-30', '', '', '', 'admin', '', 0, 1, 0, 0),
(148, 'fam1', 'g', 'm1', 'src/images/image_produits/148.jpg', 'P160', 'p12', '', '', '', 1000, 1500, 1300, 1400, 10, 3, 10, 19, NULL, '2023-09-02', '', '', '', 'admin', '', 0, 1, 0, 0),
(149, ' ', 'kg', ' ', 'src/images/image_produits/149.jpg', 'P158', 'قوقاو مملح', '', '', '', 800, 1000, 900, 480, 10, 3, 10, 19, NULL, '2023-07-30', '', '', '', 'admin', '7285960107271', 480, 30, 0, 0),
(150, 'fam1', 'g', 'm14', 'src/images/image_produits/150.jpg', 'P160', 'pro14', 'Etag', '', 'rema', 200, 250, 230, 220, 10, 3, 10, 19, '2023-07-23', '2023-09-04', 'm', '39', 'blue', 'admin', '7306791296584', 500, 1, 1, 0),
(153, 'fam1', 'piece', 'm2', 'src/images/image_produits/153.jpg', 'P154', 'pro15v2', 'etagere', '', 'remarque', 15, 20, 18, 100, 10, 20, 4, 19, '2023-07-30', '2023-07-12', 'm', '39', 'blue', 'admin', '6846914787021', 480, 31, 1, 0),
(154, ' ', 'g', ' ', 'src/images/image_produits/154.jpg', 'P154', 'vasline 45g', '', '', '', 100, 200, 100, 0, 10, 3, 10, 19, '2026-02-26', '2023-07-13', '', '', '', 'admin', '', 0, 1, 0, 0),
(155, ' ', 'mg', ' ', 'src/images/image_produits/155.jpg', 'P155', 'solyne 300mg', '1', '', '', 40, 60, 50, 0, 10, 3, 10, 19, NULL, '2023-07-13', '', '', '', 'admin', '6135632002406 ', 500, 10, 1, 0),
(156, 'pomade', 'piece', 'm1', 'src/images/image_produits/156.jpg', 'P160', 'moov', '', '', 'utiliser pour les douleurs', 300, 500, 450, 400, 9, 3, 10, 0, '2024-09-30', '2023-09-04', 'm', '39', 'black', 'admin', '8901177101502', 3500, 10, 1, 0),
(157, 'fam1', 'piece', 'nivea', 'src/images/image_produits/157.jpg', 'P160', 'nivea men', '', '', '', 300, 500, 450, 400, 10, 3, 10, 0, '2024-08-30', '2023-09-04', '', '', '', 'admin', '', 0, 1, 0, 0),
(158, 'lait', 'l', 'soumam', 'src/images/image_produits/158.jpg', 'P160', 'lait soumam 1L', '2', '', '', 100, 130, 120, 110, 10, 3, 10, 19, '2023-08-31', '2023-08-30', '', '', '', 'admin', '', 0, 1, 0, 0),
(159, 'fam1', 'piece', 'm1', 'src/images/image_produits/159.jpg', 'P160', 'simbel', '', '', '', 100, 150, 130, 120, 11, 3, 10, 19, '2025-11-01', '2023-09-25', '', '', 'blue', 'admin', '6130579000843 ', 1100, 10, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `produitteset`
--

CREATE TABLE `produitteset` (
  `categorie_produit` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `categorie_piece` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `etat` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `marque` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `numero_serie` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `référence` text DEFAULT NULL,
  `désignation` text DEFAULT NULL,
  `étagére` text DEFAULT NULL,
  `code_barre` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `remarque` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `date_achat` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `prix_achat` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `prix_vente` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `id_fournisseur` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `quantité` text DEFAULT NULL,
  `id_produit` text CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `produitteset`
--

INSERT INTO `produitteset` (`categorie_produit`, `categorie_piece`, `etat`, `marque`, `numero_serie`, `référence`, `désignation`, `étagére`, `code_barre`, `remarque`, `date_achat`, `prix_achat`, `prix_vente`, `id_fournisseur`, `quantité`, `id_produit`) VALUES
('', '', '', '', '', 'CARTIE', 'REALIS JAUNE 12V-40A', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', '', 'REALIS 12V 5F GRIS 25A', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CARTIER', 'RELAIS 5F 35A VERT ORJ HA', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', 'CARTIE', 'RELAIS MARRON 4F 12V-20A', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', '', 'RELAIS 4F NOIR OR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'BOUTON PGT 207', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '91108', 'BOUTON VITRE DE PORTE 406 GF', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', '', 'BOUTON PGT 207 4PORTE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'FICHE MANOT/CAPTEUR RLT/PGT', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'FICHE BOBINE 1', '4 1', '2/16V', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'FICHE DE LAMPE H4 BKT', '', '', 'BKT', '', '', '', '', '', ''),
('', '', '', '', '', '', 'LAMPE CLIGNOTTON COMPLET RLT NM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TD2108', 'FICHE FEMELLE PM 4', '8 500PCS', '', '', 'MESA', '', '', '', '', ''),
('', '', '', '', '', '3500126', 'REGULATEUR INCORPORE 12V 1', 'FICHE KCA', '', '', 'KCA', '', '', '', '', ''),
('', '', '', '', '', 'C120', 'APPAREILLE CLIGNOTON 3F 12V KCA', '', '', 'KCA', '', '', '', '', '', ''),
('', '', '', '', '', '121T', 'APPAREILLE CLIGNOTON 4F 12V KCA', '', '', 'KCA', '', '', '', '', '', ''),
('', '', '', '', '', '5960', 'J3', 'BOUGIE ALLUMAGE PGT 206 ESS EYQUEM', '', '', 'PGT', '', '', '', '', ''),
('', '', '', '', '', 'HTC ', 'BAGUE FIAT', '', '', 'HTC', '', '', '', '', '', ''),
('', '', '', '', '', 'HTC ', 'BAGUE BOSCH', '', '', 'HTC', '', '', '', '', '', ''),
('', '', '', '', '', 'HTC ', 'BAGUE PGT/RNLT DESSOULY', '', '', 'HTC', '', '', '', '', '', ''),
('', '', '', '', '', '', 'FUSIBLE GM ORJ 20/40/50/60/70/80', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', '242235666', 'BOUGIE SPECIALE BOSCH 01TETE', '', '', 'BOSCH', '', '', '', '', '', ''),
('', '', '', '', '', 'KIA', 'KLAXON HIGH TECH', '', '', 'HIGH TE', '', '', '', '', '', ''),
('', '', '', '', '', '', 'LAMPE D2S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'LAMPE 1P 12V BOSCH BLISTER', '', '', 'BOSCH', '', '', '', '', '', ''),
('', '', '', '', '', '', 'LAMPE 2P BLISTER BOSCH', '', '', 'BOSCH', '', '', '', '', '', ''),
('', '', '', '', '', '', 'FUSIBLE NM 10-15-25-30', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', '', 'FUSIBLE COSSE ORJ ', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', '', 'COMMODO LOGANE/SYMBOLE NM ', '', '', 'RLT', '', '', '', '', '', ''),
('', '', '', '', '', '', 'THEN 1/2KG', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'DOUIT AVEC LAMPE OSRAM', '', '', 'OSRAM', '', '', '', '', '', ''),
('', '', '', '', '', '86286', 'LAMPE VEILLEUSE AM 12V 5W BA15S GRAI', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86311', 'LAMPE T10 12V WB 5W GM', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86317', 'LAMPE TABLEAU DE BORD T5 12V', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '81018', 'PORTE CHARBON 1', '9 157/158 DONON', '', '', 'DONON', '', '', '', '', ''),
('', '', '', '', '', '3500126', 'REGULATEUR INCORPORE 12V 1', 'FICHE KCA', '', '', 'KCA', '', '', '', '', ''),
('', '', '', '', '', '81010', 'PORTE CHARBON 1', '9 159/160 DONON', '', '', 'DONON', '', '', '', '', ''),
('', '', '', '', '', 'CB1-14', 'CHARBON ALT PM DONON', '', '', 'DONON', '', '', '', '', '', ''),
('', '', '', '', '', '2706', 'FICHE ROND MALLE 300PCS', '', '', 'MESA', '', '', '', '', '', ''),
('', '', '', '', '', '2613', 'FICHE ROND FEMELLE 300PCS', '', '', 'MESA', '', '', '', '', '', ''),
('', '', '', '', '', '', 'CHATARTON ABRO', '', '', 'ABRO', '', '', '', '', '', ''),
('', '', '', '', '', '', 'CHATARTON GM ORJ', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', '86311', 'LAMPE T10 12V WB 5W GM', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86317', 'LAMPE  TABLEAU DE BORD T5 12V ', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86200Z ', 'LAMPE H4 CODE PHARE 12V P43 60/55W', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86276', 'LAMPE 1P CLIGNOTON 12V 21W', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86280', 'LAMPE 2P STOP 12V 21W', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86230', 'LAMPE CODE H7 12V 55W PX26D', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '', 'FUSIBLE GM ORJ 20/40/50/60/70/80', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', 'CARTIER', 'RELAIS 5F 35A VERT ORJ HA', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', 'CARTIE', 'RELAIS JAUNE 5F 12V-40A', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', '', 'RELAIS 4F NOIR OR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'MANOT FEUX DE RECUL RLT 1', '9', '', '', 'ORJ', '', '', '', '', ''),
('', '', '', '', '', '8200209496', 'MONOT FEUX DE RECUL CLIO III LOGANE 1', '4 1', '2 16V ', '', '', 'ORJ', '', '', '', ''),
('', '', '', '', '', '9663906680', 'MANOT MARCHE', 'ARR PGT', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'MANOT CLIM PGT PART 206', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', '9662906780', 'MANOT MARCHE', 'ARR NOIR ', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'GF011', 'COSSE BATTERIE GF', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', 'BKT1900', 'KLAXON STD BKT', '', '', 'BKT', '', '', '', '', '', ''),
('', '', '', '', '', 'CB11-8/9', 'CHRBON BEM JET DONON ', '', '', 'DONON ', '', '', '', '', '', ''),
('', '', '', '', '', 'TJ11-6A/7A', 'CHARBON DEM VALEO DONON', '', '', 'DONON ', '', '', '', '', '', ''),
('', '', '', '', '', '', 'BAGUE ALT CH', '', '', 'CH', '', '', '', '', '', ''),
('', '', '', '', '', '', 'BAGUE ALT BERT', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'INJECTEUR RLT 1', '4 SYMBOLE', '', '', 'RLT', '', '', '', '', ''),
('', '', '', '', '', '201003051', 'RELAIS 12V 5F 40/30A ELO ', '', '', 'ELO', '', '', '', '', '', ''),
('', '', '', '', '', 'RI124', 'REGULATEUR INCORPORE 12V BOSCH KCA ', '', '', 'KCA', '', '', '', '', '', ''),
('', '', '', '', '', '85038', 'MANOT STOP VAV', '', '', 'VAV', '', '', '', '', '', ''),
('', '', '', '', '', '85111', 'MANOT STOP CLIO III LAG 24898 VAV', '', '', 'VAV', '', '', '', '', '', ''),
('', '', '', '', '', '84066', 'MANOT RADIATEUR VAV', '', '', 'VAV', '', '', '', '', '', ''),
('', '', '', '', '', '85112', 'MANOT STOP VAV', '', '', 'VAV', '', '', '', '', '', ''),
('', '', '', '', '', '86280', 'LAMPE 2P STOP 12V 21W', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86201Z', 'LAMPE ANTI BROUILLARD H3 12V 55W ', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86286', 'LAMPE VEILLEUSE AM 12V 5W BA15S GRAI', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86404Z ', 'LAMPE CLIGNOTTON 1P 12V 21W ORANGE', '', '', 'KLAXCA ', '', '', '', '', '', ''),
('', '', '', '', '', '86423', 'LAMPE DE STOP 03EM POSITION T15 12V', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '62198', 'BAGUE DEM 1', '9 DONON', '', '', 'DONON', '', '', '', '', ''),
('', '', '', '', '', '', 'BOUTON DETECTEUR PLAFONIER RLT', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', 'CARTIE', 'RELAIS MARRON 4F 12V-20A', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', 'CARTIE', 'RELAIS BLEU 4F 12V-35A CARTIE', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', '', 'RELAIS VIOLET + ROUGE CARTIE ', '', '', 'CARTIE', '', '', '', '', '', ''),
('', '', '', '', '', '', 'RELAIS GRIS 12V 4F', '', '', 'ORJ', '', '', '', '', '', ''),
('', '', '', '', '', 'NV', 'FUSIBLE NV ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'THEN 1/2KG', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '', 'LAMPE T10 ORANGE ORJ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '861317', 'LAMPE TABLEAU DE BORD T5 12V', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86311', 'LAMPE T10 12V WB 5W GM ', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86230', 'LAMPE CODE H7 12V 55W PX26D', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86202', 'LAMPE PHAR H1 12V 55W P145S', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '86200Z ', 'LAMPE H4 CODE PHARE 12V P43 60/55W', '', '', 'KLAXCA', '', '', '', '', '', ''),
('', '', '', '', '', '81033', 'PORTE CHARBON JET COMPLET DONON', '', '', 'DONON', '', '', '', '', '', ''),
('', '', '', '', '', '81298', 'PORTE CHARBON 1', '9 GM DONON', '', '', 'DONON', '', '', '', '', ''),
('', '', '', '', '', '81159', 'PORTE CHARBON 1', '9 KANGO DONON ', '', '', 'DONON ', '', '', '', '', ''),
('', '', '', '', '', '81157', 'PORTE CHARBON 1', '9 PM DONON', '', '', 'DONON', '', '', '', '', ''),
('', '', '', '', '', 'AZIAT ', 'APPAREIL CLIGNOTEUR 3F PM AM AZIATTIC', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '3323', 'APPAREIL CLIGNOTEUR 4F *12V*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AB', 'BOUCHON DE HUILLE KANGO', 'EXP', 'CLIO', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PLO', 'BOUCHON VASE LAVE GLASSE MEGANE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DSQ', 'BOUCHON VASE LAVE GLASSE PGT/CITR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BIT', 'BOUTON ROUG AVEC FICHE GM ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'A369', 'BOUTON ROUG AVEC FICHE PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6554EQ', 'BOUTON VITRE 307 *RABATABLE*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1', '5', 'CABLE D INST 1', '5 *1*', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX-004', 'CHARBONAT SVX-004 TERNATEUR PM *07* VALIO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'A326', 'CHARTETON *DURITE*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'MO', 'COLIER PLASTIC *5X380M*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '700GM', 'COUSE BATERI BRASS 700GM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'RT', 'DIODE FRAC', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'IDR197', 'DIODE RENT', 'GHT', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T10', 'FICHE T10', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'J91-986', 'FICHE A FICHE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '150A', 'FICHE COUSE 150A PLAQ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FICH', 'FICHE FEMELLE GM 1EM ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TM 14', 'FICHE MALLE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ANS50900', 'FUSIBLE MEC PM COUVRET *100PCS*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '16/20/25/30', 'FUSIBLE PLASTIC 16/20/25/30 AM 100 PCS', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '415280', 'INDICATEURE TOMPERATEUR 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'IN', 'INDICATEURE FOMPERATEUR 12V CAREE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '91735', 'MANO DE STOP 404/4534-02', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'GHF30014', 'MANO DE STOP J5 *PLASTIC* 4534-06', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '225717', 'MANO MAECHE ARIARE 205 405', 'J5', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '37980', 'MANO RADIATEUR *92/82-96/82*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '24212', 'MANO RADIATEUR 68*82 *HTC*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7700782503', 'MANO RADIATEUR DIESEL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'POMP5', 'POMPE LAVE GLACE 505', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5062', 'REGULATEUR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5013', 'REGULATEUR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'B0707M', 'REGULATEUR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M0689', 'REGULATEUR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'P01652-2', 'REGULATEUR 12V 2FICH', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5014', 'REGULATEUR GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5011', 'REGULATEUR GF-VALIO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'GHF NO254', 'REGULATEUR MAROTI', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '475', 'RELAIS CHOUFAGE J5/J9/505* KHENTEUR *', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '965808980', 'RELAIS RESISTANCE 406', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DG343', 'ROULMENT DIRECTION GHF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SEN009', 'SERRURE MAL MEGANE *ELC*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '440609-01', 'SERRURE MAL RENT *ELC*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ES509', 'SILICON CAFTAR  PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '15R', 'TUYEAU LAVE GLASSE *1EM*', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '45025Z', 'BOBINE CLIO KANGO ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'KM0615', 'BOUTON FOU DETRESSE KANNGO/CLIO III', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '96401469XT', 'BOUTON V C3/C2', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'K-HAIT', 'KLAXO France TEHC                 OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '55BI12', '094', '01M', 'KLAXO 12V MASTER/LOGAN ', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FAE12630', 'MANO HUILE VER ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FAE40600', 'MANO MARCHE AR RNT', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6200SNR', 'ROUL 6200 SNR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6203SNR', 'ROUL 6203 SNR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DI502', 'TRETMON INJECTEUR DIASEL ABRO ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0505261', 'RELAI GOLF/I/II/III JETTA ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0604804  B', 'CAPT ABS AVG/POLO/1', '9/1', '4 TDI', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0603433', 'CAPT PMH/GLF/VI/A1/A3/1', '4/2', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0604804  ', 'CAPT SEAT/GOLF III / IV /1', '0/1', '4', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0603601E', 'CAPT AC/POLO/FABIA/GLF/V/VI/1', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0607001', 'CAPT PRES PGT/FIAT/VW/HYND  ES', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12V92W4N', 'CENTRALE CLIGNOTANTE 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '9126719', 'MANO RADIAT 306-406', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0509178', 'RELAT 405/406', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0134507', 'REGUL VW/SEAT/AUDI', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ01351639', 'REGUL RENAULT', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0101385', 'REGUL PGT/FIAT/IVECO/AUDI/NIS', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0101388', 'REGUL VW/PGT/FORD/SKODA', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0101512', 'REGUL 106/306/405/406/605/806', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0101225', 'REGUL GOLF4/5/RLT 1', '9-2', '0 TDI+', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0117110', 'REGUL F131/TIPO 1', '0/1', '3/1', '4D', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0101239', 'REGUL CLIO/MEG/KANG', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0134131C', 'REGUL PGT', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '9234802', 'CAPT VIT 306/206/SAXO/1', '4/1', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0601770', 'CAPT VIT MEG 2', '0/KANGOO', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PSX 131', 'JX CHARB DEMAR 404 504 505', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'JAAX 35P2', 'JX CHARB HILUX+ENGINS', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BSX 159-160P1', 'PORT CHARB 206/306/307/PART  1', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'JASX 39P ', 'JX CHARB PICANT MARUTI ALTO ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PSX 142-145P1', 'JX CHARB RN PSA (VALEO)', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BSX 161-162LP', 'JX CHARB ACCENT FORD (BOSCH)', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'JASX 40-41P', 'PORTE CHARB RLT  1', '5 DCT PAJER', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PSX 142-145PK', 'PORT CHARB RESSORT +CABLE 405 ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PSX155P', 'PORT CHARB CLIO KANG MEG BERL ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PSX 146-147K', 'JX CHARB DEMAR 206 306 406 KI ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'EFP 380201G', 'PPE ESS FIAT PALIO SIEHA CHANI ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6201', 'ROUL ALTERN ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DZ0604808  B', 'CAPT SEAT/SKODA/POLO/1', '2/1', '4T', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ALM', 'ALLUME SIGARET 12V SP         OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX031-2', 'BAG 031-2', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1', 'BAG HT STD', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '8200702693', 'BOBINE 1', '2 16V', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'KR432', 'BOUTON MALLE CLIO 3 ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T5S1', 'DOUI LAMPE TABLO T5', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7700410754', 'FEU MATRUQUL CLIO II        AB', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TD2114', 'FICHE FEMALLE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'GM60', 'FICHE FEMELLE   GM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1', '5', 'FILE ELC 1', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FAM', 'FUSIBLE II PLAQ  GM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0123', 'LAMPE VEUS LED S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '662022', 'LAMPE H1 12V 55W', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'B62002', 'LAMPE H4 P43 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '862302', 'LAMPE H7 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86330Z', 'LAMPE NAVETE 12V 41MM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '863252', 'LAMPE NAVETE PM 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86311Z', 'LAMPE T10 5W 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86317Z', 'LAMPE T6 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0443', 'LAMPE LAD T5       S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1249982', 'LAMPE PHILIPS 2P 12V PLISTER', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12362PRC1 ', 'LAMPE PHILIPS H11 12V VISION BOITZ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0016', 'POMPE SONTRALISI 2FIL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0019', 'POMPE SONTRALISI REN     S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81157', 'PORTE CHARBON 19 PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TSJDD162', 'PORTE CHARBON ACECTI 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T3801', 'RELAI CHOFACH STD        SS', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '9251586780', 'RELAIS CHOFAGE STD', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6201BW', 'ROUL 6201 BW', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6303BW', 'ROUL 6303 BW', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '70717', 'BOUCHON VASE DEAU CLIO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'G4', '157', 'BOUGIE P', 'CHO CLIO II/KANG 1', '9 FICHE   DISAX ', '', '', '', '', '', ''),
('', '', '', '', '', 'G2', '130R', 'BOUGIE P', 'CHO CLIO/EXP 1', '6  DEDAX', '', '', '', '', '', ''),
('', '', '', '', '', 'G1', '245', 'BOUGIE P', 'CHO KANGOO 1', '9 /TRAFIC/CLIO FICHE DEDAX', '', '', '', '', '', ''),
('', '', '', '', '', 'G1', '131', 'BOUGIE P', 'CHO SAXO/XARA/PARTN 1', '9D   DEDAX', '', '', '', '', '', ''),
('', '', '', '', '', '91117', 'BOUTON FEU DE TRESSE  GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'KM0701', 'BOUTON RET MEG II/CLIO III/ KANGO III', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '532697048', 'BOUTON V 207 4P NM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'KM0614', 'BOUTON V 2B', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6554CF 2P ', 'BOUTON V 406 2P ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '128412H', 'BOUTON V CLIO BLANC 1P    HTC', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '8090611667L ', 'BOUTON V CLIO III DACIA ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '809602454R', 'BOUTON V CLIO III DACIA     GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '16004', 'BOUTON V EXPERT 2006 1', '6 HDI ', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6', 'CHARTETON SAMETTEX    10', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '20-32S', 'COLAI 20/32   S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '700G ', 'COSSE BATTERIE COUVER 700G       GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '110A', 'COURONNE DIESEL ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'WM600-67', 'DOUI LAMPE 1P PLASTIC GM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '5021/16', 'DURIT STD PM 12', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '114971', 'ENDUIT DEM VALEO JTB 13D ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ981', 'FICHE    A/M', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ3102', 'FICHE AUTO ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PLAQ', 'FICHE COSSE PLAQ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TD2114 ', 'FICHE FEMALLE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'H4-F', 'FICHE H4 II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ1315A', 'FICHE H7', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '2', '5', 'FILE ELC 2', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FU22', 'FUSIBL II BOIT MOI STD', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '28881', 'LAMPE GF H4 12V P43', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '28328', 'LAMPE GF H7 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T20', 'IP', 'LAMPE II  T20  1P', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0459', 'LAMPE NAVETTE LED   S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12258PR', 'LAMPE PHILIPS H1 12V BOITE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN0965', 'LANCEUR 106/206ESS/CLIO  1', '2', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN1058', 'LANCEUR RNT CLIO KANG MGN 1', '9D R19 TRAFIC/58', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'KR-563', 'PLAOHONNE CLIO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0015', 'POMPE SONRALISI 5FIL ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PSX148/149', 'PORTE CHARBON', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BH148', 'PORTE CHARBON JETAB', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'VR-VL1012', 'REG 1012 CLIO III  VALEO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5016', 'REGULATEUR 12V ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1607401680', 'TUYAU POMPE ESS PGT ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7700432007', 'TUYAU POMPE ESS RNT', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', ' 4', '8X400', 'ATACHE PLAST MOIAN NOIR/BLANC 4', '8X400', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BC-V010', 'BAG 010 ALT NOIR/BLANCH      AO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'D3735110DA', 'CENTRALE CLIGNOTON 12V         HTC', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX-003', 'CHAR 003               GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX-004', 'CHAR 004               GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7320-4', 'CHAR 7320-4 JETABL    148-149       ST-II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'IM3153', 'ENDOIU DEM 10D JETA          AM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'J91-1951-1', 'FICHE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1', '5', 'FILE ELC 1', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', 'K-KAIT ', 'KLAXO France TEHC                 OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '55BI12', '094', '01K', 'KLAXO 12V MASTER/LOGAN ', '', '', '', '', '', '', ''),
('', '', '', '', '', '86276Z', 'LAMPE 1P 12V ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86280Z', 'LAMPE 2 POLO 12V KLAX', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86311Z', 'LAMPE T10 5W 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '28328', 'LAMPE GF H7 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'H11', '12', '2', 'LAMPE II H11 12V ', '', '', '', '', '', '', ''),
('', '', '', '', '', '12498CP ', 'LAMPE PHILIPS 1P 12V BOITE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12499B2', 'LAMPE PHILIPS H1 12V PLISTER ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12258PR', 'LAMPE PHILIPS H1 12V BOITE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'MG06-01040', 'POIGNE INT CLIO CHOMI', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0016', 'POMPE SONTRALISI 2FIL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81297', 'PORTE CHARBON 1', '5 DCI', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81017C', 'PORTE CHARBON 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '614-0116', 'PORTE CHARBON 1', '9 BSX159-160    BH210', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81157', 'PORTE CHARBONE 1', '9 PM', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81236', 'PORTE CHARBONE VW/HDI 1', '6', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6202SNR ', 'ROUL 6202 SNR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AB-GM', 'ARALDITE AB GM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BSX001-17', 'BAG 001-17 DEM 1', '9D         A/M      GF', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BOT02', 'BOUTON POSOIR FILLE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '8090611667L ', 'BOUTON V CLIO III DACIA', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '809602454R', 'BOUTON V CLIO III DACIA          GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CS8406', 'CAPTEUR CLIO 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PS8265', 'CAPTEUR DE PRESIO CLIO 1', '2/1', '4', '', '', '', '', '', '', ''),
('', '', '', '', '', 'D6RACCW ', 'CARCASSE DEM VALEO   A/M    021', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AM-005', 'CASSETE 6F', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX-004', 'CHAR 004               GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7320-4', 'CHAR 7320-4 JETABL    148-149       ST-II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '0', '45MM*17MM', 'CHARTETON CATEN GM            F', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '8-12S', 'COLAI 08/12      S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '10-16S', 'COLAI 10/16      S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '60-80S', 'COLAI 60/80      S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZM490', 'CONTACTEUR CITOEN/PEUGOT/90', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '20301090', 'CONTAQTER 573', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '700G', 'COSSE BATRIE COUVER GM 700G       GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'J91-211', 'DOUI LAMP 1P MITAL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'J91-212', 'DOUI LAMP 21 MITAL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'J91-2983', 'FICHE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ981', 'FICHE    A/M', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ1812', 'FICHE    A/M', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TS2414', 'FICHE COSSE   ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TS2428', 'FICHE COSSE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TS2424', 'FICHE COSSE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TD2128  ', 'FICHE FEMALLE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TD2114', 'FICHE FEMALLE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ-1318A', 'FICHE RELAIS', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1', '5', 'FICHE ELC 1', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', '1', '4 PLAS ', 'FILTER ESS 1', '4 PLASTIC        AB', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST 10020', 'FUSIBLE 20A (50)', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST 10025', 'FUSIBLE 25A (50)', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST10030', 'FUSIBLE 30A (50)', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'P0098', 'FUSUBLE BOIT TOYOTA', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'K-HAIT', 'KLAXO France TEHC                 OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '50FO24', '094', '00', 'KLAXO 24V JEU ', '', '', '', '', '', '', ''),
('', '', '', '', '', '86404Z ', 'LAMPE 1P ORANGE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86301Z', 'LAMPE BAIONAT 12V 4W', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86202Z', 'LAMPE H1 12V 55W', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86200Z ', 'LAMPE H4 P43 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86321Z', 'LAMPE NAVETE 12V   ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86318Z', 'LAMPE T10 3W  24V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86317Z', 'LAMPE T5 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0459', 'LAMPE NAVETTE LED   S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12499B2', 'LAMPE PHILIPS 2P 12V PLISTER', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12342PR ', 'LAMPE PHILIPS H4 12V BPITE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN0965', 'LANCEUR 106/206ESS/CLIO  1', '2', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LT-2', '6', 'LETAN', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '33724', 'MANO CULACE CLIO/KANGO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'MG06-01040', 'POIGNE INT CLIO CHOMI', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PO-C2', 'POIGNE INT CLIO II CABLE    CH', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7700430704', 'POMPE LAVE GLACE 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '54511Z', 'POMPE LAVE GLACE BERLINGO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '54512Z', 'POMPE LAVE GLACE MEGAN ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0019', 'POMPE SONTRALISI REN     S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81017C', 'PORTE CHARBON 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81157', 'PORTE CHARBON 1', ' PM', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '617-0115', 'PORTE CHARBON 1', '9 BSX157/158', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6628P', 'PORTE CHARBON ASSISTI     A/M', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BH210', 'PORTE CHARBON KANGO/CLIO  MM  159/160', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5082', 'REGULATEUR  F     GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M50229', 'REGULATEUR  12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6441L2', 'RESISTANCE AU VENTILAT  207/107/406', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1267J6 ', 'RESISTANCE AU VENTILAT  207/208/C2/C3/301', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '966240180 GF', 'RESISTANCE PARTNER', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6450NX', 'RESISTONCE AU VENTILAT CITRO/PEUGE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7701051272', 'RESISTONCE AU VENTILAT CLIO  II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6202SNR ', 'ROUL 6202 SNR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6303NSK', 'ROUL 6303NSK', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SS8283', 'TAQUMATR       H', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SS7719', 'TAGUMATR KANGOO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AB-PM', 'ARALDITE AB GM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '0066-5', 'BAG 0066-5', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX031-2', 'BAG 031-2 CHNAFA      GF/      ST-II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '130', 'BOUTON V          A/MOTIV', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '145', 'BOUTON V          A/M  ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6490X9', 'BOUTON V  BOXER III', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'KM-346', 'BOUTON V CLIO 2P NOIR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CS8406', 'CAPTEUR CLIO 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '90073', 'COMANDO EXPRES NM ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '90072', 'COMANDO R4', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '20301090', 'CONTAQTER 573', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CM001', 'COSSE BATTRIE MEGAN   II/LAGUN    H', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1120', 'FEU MATRIQIL EXP     AB', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TS2414', 'FICHE COSSE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TKS1408', 'FICHE COSSE 10', '', '', '', '', '', '', '150PC', '', ''),
('', '', '', '', '', 'PLAQ ', 'FICHE COSSE PLAQ ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'K-HAIT ', 'KLAXO France TEHC                 OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86276Z', 'LAMPE 1P  12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86317Z', 'LAMPE T5 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '37177', 'LAMPE GF  T10 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0443', 'LAMPE LAD T5       S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN0938', 'LANCEUR FORD/FESTA ESS', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '54520Z', 'POMPE LAVE GLACE TOYOTA/MITSUB', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0019', 'POMPE SONTRALISI REN     S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'P81038', 'PORTE CHARBO AVEO     A/M', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7701028400', 'REGULTE 2 FICHE     HTC', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '50000', 'TERMOMETR ROND          GF ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'R55570', 'VASE D EAU LAVE GLACE 12V STD', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AG-P', 'AGRAF PASSAG DE R CH ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '352', '88', 'ANTIVOLE A/S  CLIO I', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1524', '5', 'ANTIVOLE A/S  CLIO III/KANGOO III      A/S', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1520', '39', 'ANTIVOLE A/S EXPRES ', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1522', '63', 'ANTIVOLE A/S J5/C25', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '0066-13', 'BAG ALT 0066-13', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BC-V019', 'BAG ALT 019     S/LECT     AO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '614-0129', 'BAG  D  614-129', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '62033', 'BAG  D 62033 JET 12-15 BOSCHE     ST-II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '06-0949-2F', 'BOUTON INTRIPTOUR NOIR 2F      ITALY', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DS21B ', 'BOUTON POSOIR  CHROME  PM ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '91103', 'BOUTON V          GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '91111', 'BOUTON V  6F NOIR         GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BSX133', 'CHAR 133  404/EXT/R4        ST', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BSX161-162', 'CHAR 161-162 TDI 205 PM  ST ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '5709-5', 'CHAR 5709-5  EXP      ST-II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7320-5', 'CHAR 7320-5 DEM 1', '6 HDI        ST-II', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'II1B', 'COURONE MASTER MEIAL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T5S1', 'DOUI LAMPE TABLO T5', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'IA5000', 'ENDOI DEM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '116421', 'ENDOUIT DEM VALIO 8DJTBL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '619125', 'ENDOUI DEM KANGOO/CLIO  1', '9D', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'YPX0022', 'FILE BAFE 100M S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '48002Z', 'FILE BOUGIE CLIO 1', '2', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST10010', 'FUSIBLE 10010', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST10015', 'FUSIBLE 10015', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ATN20900', 'FUSIBLE 20900  MELONG', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ANS50900', 'FUSIBLE 50900 MEONG (25)', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'K-HAIT', 'KLAXO France TEHC                 OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0123', 'LAMP VEUS LED S ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86594Z', 'LAMPE 207 ANTIBR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86202Z', 'LAMPE H1 12V 55W', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86201Z', 'LAMPE H3 12V 55W', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86225Z', 'LAMPE H4 P43 24V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86233Z', 'LAMPE H7 24V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86286', 'LAMPE VEILLEUSE 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0029', 'LAMPE LED T10  9P', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LT-2', '6', 'LETAN', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FAE1141', 'MANO HUIL RNT', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FAE37480', 'MANO RADI 75-68      FAE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FAE24895', 'MANO STOP 4F RNT ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '21024', 'MANO STOP STD PLAQ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81317', 'PORTE CHARBON ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81297', 'PORTE CHARBON 1', '5 DCI', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BH215', 'PORTE CHARBON BOSH-ISP', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5031', 'REGULATEUR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5082', 'REGULATEUR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M5016', 'REGULATEUR 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'M50229', 'REGULATEUR  12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '5F-MAR ', 'RELAIE 5F/4F  MARON/ JONE     PM  OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '841235', 'RELAIS         GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '831250', 'RELAIS         GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7700844682', 'RELAIS        ROUGE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6202SNR ', 'ROUL 6202 SNR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6303BW', 'ROUL 6303 BW', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '321121142', 'SER CLISE MANO NOIR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T-AL002', 'TENDOUR ALTIRNZTEUR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'X-H7 VOL', 'XENOUN H7 LZD VOLTEC', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '100', '767', '404', 'ANTIVOL CFA EXP', '', '', '', '', '', '', ''),
('', '', '', '', '', '1521', '13', 'ANTIVOLE A/S  306 93-04 /PART', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '352', '88', 'ANTIVOLE A/S CLIO I', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1522', '4', 'ANTIVOLE A/S CLIO II', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1524', '5', 'ANTIVOLE A/S CLIO III/KANGOO III      A/S', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AB-PM', 'ARALDITE AB PM ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '4', '8X400', 'ATACHE PLAST MOIAN NOIR/BLANC 4', '8X400', '', '', '', '', '', '', ''),
('', '', '', '', '', '7700308821', 'BOUTON FEU DETRESSE KONGOO   GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '20A125V', 'BOUTON INTERPTEUR ROUF I 0 II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '10V125V', 'BOUTON INTERPTEUR ROUG PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7L6959855', 'BOUTON V GOLF 1P       PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '5GG959857', 'BOUTON V GOLF 7  G', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '01403-12V', 'CENTRAL CLIGNOTON 4F 12V A/MO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '2107', 'CENTRAL CLIGNOTON 3F 12V       A/MO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX-021', 'CHAR 021 ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX7', 'CHAR 7 ALT     A/M', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7701040730', 'COMANDO KANGO/CLIO     HTC', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '102044', 'COMANDO LOGAN NM ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZM490', 'CONTACTEUR CITOEN/PEUGOT/90', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZM2-494', ' CONTACTEUR/94', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ1057', 'DOUI FEU POSTION T10  3W', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T5S1', 'DOUI LAMPE TABLO T5', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '11030-0', 'ENDOUI DEM 1', '5 DCI PM         A/M', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TD2114', 'FICHE FEMALLE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'J91-1776', 'FICHE TAKIMETRE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FAM', 'FUSIBL II PLAQ GM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ATM16900', 'FUSIBL 16900', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'FLM70900', 'FUSIBL 70900 MELONGE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86276Z', 'LAMPE 1P  12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '86230Z', 'LAMPE H7 12V ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '37177', 'LAMPE GF T10 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'H11', '12', '2', 'LAMPE II H11 12V ', '', '', '', '', '', '', ''),
('', '', '', '', '', '12V21/5W', 'LAMPE II T20 2P', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12498B2', 'LAMPE PHILIPS 1P 12V PLISTER', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12499B2', 'LAMPE PHILIPS 2P 12V PLISTER', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'MCMK10-138', 'LAMPE STOP PHLACHE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN0482', 'LANCHUR 2052/305/R9/VW', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN0630', 'LANCHUR KANGOO CLIO 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN1801', 'LANCHUR LOGANE NM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEM1559', 'LANCHUR MEGANE 3 BOCSH', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LT-2', '6', 'LETAN', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '101968', 'MANO CULASSE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '33724', 'MANO CULASSE CLIO /KANGO ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '54507Z', 'POMPE LAVE GLACE 405', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0015', 'POMPE SONTRALISI 5FIL', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0019', 'POMPE SONTRALISI REN     S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81217C', 'PORTE CHARBON 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '614-0128', 'PORTE CHARBONE 1', '9 GM 157-158', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6160', '7', 'TAQUMETRE 306/PART/XARA', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'K', 'HAIT', 'KLAXO France TEHC                 OR', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '700G', 'COSSE BATRIE CUIVRE 700G   GF', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', '1', '5', 'FILE ELECT 1', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', '2', '5', 'FILECT  2', '5', '', '', '', '', '', '', ''),
('', '', '', '', '', '9251586780', 'RELAIS CHAUFAGE STD', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZM573', 'CONTACTEUR FIAT/VW/AUDI/173', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZM697', 'CONTACTEUR MAZDA/KIA/AVEO/ACCENT/97', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZM597', 'CONTACTEUR 305/505/TRAFI/MERCDS/FRD/GM/97', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ZM490', 'CONTACTEUR  CITR/PGT/90', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '418919', 'TAQUIMATER KANGOO  OR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'F100', 'FUSIBL II BOIT PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ANT20900', 'FUSIBL MELONG', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST10010', 'FUSIBL  10010', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST10015', 'FUSIBLE 10015', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '158265', 'FICHE CAPTEUR ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '352', '88', 'ANTIVOL  A/S  CLIO I', '', '', 'AUTOSTAR', '', '', '', '', ''),
('', '', '', '', '', '1522', '4', 'ANTIVOL  A/S  CLIO II', '', '', 'AUTOSTAR', '', '', '', '', ''),
('', '', '', '', '', '1524', '5', 'ANTIVOL  A/S  CLIO III/ KANGOO III', '', '', 'AUTOSTAR', '', '', '', '', ''),
('', '', '', '', '', 'VR-B1193', 'REG BOSCH', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'C120T', 'CENTRAL CLEIGNOTON 12V  S', '', '', 'K', '', '', '', '', '', ''),
('', '', '', '', '', '254110431', 'BOUTON V KANGO III/LOGAN', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'B06026', 'REGULATEUR BOXER 12V', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', '814243', 'PORTE CHARBON GF', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', '81236', 'PORTE CHARBON VW/HDI  1', '6', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81297', 'PORTE CHARBON 1', '5 DCI', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '81033', 'PORTE CHARBON ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PS8265', 'CAPTEUR PRESSION CLIO 1', '2/1', '4', '', '', '', '', '', '', ''),
('', '', '', '', '', 'TD2114', 'FICHE FEMELLE ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '2107', 'CENTRAL CLEIGNOTON  3F 12V A/M', '', '', 'AUTOMOTIV', '', '', '', '', '', ''),
('', '', '', '', '', '01403-24V', 'CENTRAL CLEIGNOTON 24V 4F A/M', '', '', 'AUTOMOTIV', '', '', '', '', '', ''),
('', '', '', '', '', '614-0116', 'PORTE CHARBON 1', '9', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SVX-004', 'CHAR 004               GF', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', 'S0019', 'POMPE SENTRALISI REN  S', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '118001', 'ENDOUI DEM DENSO 207/BERL 1', '6 HDI', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'S0016', 'POMPE SENTRALISI 2F', '', '', 'SALAMA', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN1801', 'LANCEUR LOGANE NM', '', '', 'ZEN', '', '', '', '', '', ''),
('', '', '', '', '', 'ZEN1058', 'LANCEUR RNT CLIO/KANGO/MEG  1', '9/R19/TRAFIC', '', '', 'ZEN', '', '', '', '', ''),
('', '', '', '', '', 'ZEN0630', 'LANCEUR KANGO/CLIO', '', '', 'ZEN', '', '', '', '', '', ''),
('', '', '', '', '', 'N01', 'BOUGIE EYQ', '', '', 'MDA', '', '', '', '', '', '');
INSERT INTO `produitteset` (`categorie_produit`, `categorie_piece`, `etat`, `marque`, `numero_serie`, `référence`, `désignation`, `étagére`, `code_barre`, `remarque`, `date_achat`, `prix_achat`, `prix_vente`, `id_fournisseur`, `quantité`, `id_produit`) VALUES
('', '', '', '', '', 'N50', 'BOUGIE EYQ 406', '', '', 'MDA', '', '', '', '', '', ''),
('', '', '', '', '', 'N59', 'BOUGIE EYQ ALTO/FIAT ', '', '', 'MDA', '', '', '', '', '', ''),
('', '', '', '', '', 'N58', 'BOUGIE EYQ 1', '2 16V', '', '', 'MDA', '', '', '', '', ''),
('', '', '', '', '', '7700810396', 'RELAIS 50A  MOVE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '841240', 'RELAIS', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', '4', '8X400', 'ATACHE PLAST MOIAN NOIR/BLANC 100P', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'D0013', 'ATACHE PLAST GM', '', '', 'SALAMA', '', '', '', '', '', ''),
('', '', '', '', '', 'RI125', 'REG 2F 12V  S', '', '', 'K', '', '', '', '', '', ''),
('', '', '', '', '', '50-70S', 'COLAI 50/70 S AR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'J91-1776', 'FICHE TAKIMETRE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'ET912', 'CHARTETON ABRO', '', '', 'ABRO', '', '', '', '', '', ''),
('', '', '', '', '', 'WACHER', 'POMPE LAVE GLACE STD', '', '', 'CH', '', '', '', '', '', ''),
('', '', '', '', '', 'J0063', 'CHARTETON KATAN PM  F', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'P-L', 'OR', 'POMPE LAVE GLACE A OR ', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AB-BM', 'ARADITE AB PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12499CP', 'LAMPE PHILIPS 2P 12V BOITE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12498CP ', 'LAMPE PHILIPS 1P 12V BOITE', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12342PR ', 'LAMPE PHILIPS H4 12V BPITE ', '', '', 'MDA', '', '', '', '', '', ''),
('', '', '', '', '', '12972PR', 'LAMPE PHILIPS H7 12V BPITE', '', '', 'MDA', '', '', '', '', '', ''),
('', '', '', '', '', '12258PR', 'LAMPE PHILIPS H1 12V BOITE', '', '', 'MDA', '', '', '', '', '', ''),
('', '', '', '', '', '12961CP', 'LAMPE PHILIPS T10 5W 12V BOITE', '', '', 'MDA', '', '', '', '', '', ''),
('', '', '', '', '', '380201', 'POMPE ESS CLIO ZORAN', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '5709-5', 'CHAR 5709-5    ST/II', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'A01353', 'BAG ALTERN 01353', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', 'PSX142/143', 'CHAR142-143 EXP/405/VALEO   ST', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'SQ1057', 'DOUI FEU POSITION T10 3W', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'DS21B ', 'BOUTON POUSOIR CHOME PM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6A250V', 'BOUTON 1-0 PM ROND', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1', '0-3F', 'BOUTON 1-0 PM CARI', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'T5S1', 'DOUI LAMPE TABLO T5', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '5408', 'DIOD FUSIBLE F', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '7702127213', 'MOTEUR CONDANASIO GF', '', '', 'GF', '', '', '', '', '', ''),
('', '', '', '', '', 'DOT4I', 'HUILE DOT4 55+BENDIX', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CF356', 'FILER HABITDX PARTNER AM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CF500', 'FILER HABIT MEGAN3/SCENIC3/FLUENCE 272778970R', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CF293', 'FILTER HABIT KANGOO NM MEGANE3', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CF243', 'FILTER HABITDX KANGO NM MASTER', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CF254', 'FILTER HABIT MEGANE 1 AM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'MD-6447VY', 'FILTER HABIT KANG LOGAN CF834', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CF170', 'FILTER HABIT CLIO 4 LOGAN NM', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'CF930', 'FILTER HABIT CLIO 3', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '6200SNR', 'ROUIMENT 6200 SNR', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '100', '767', '404', 'ANTIVOL CFA EXP', '', '', '', '', '', '', ''),
('', '', '', '', '', '7700308821', 'BOUTON FEU DE TRESSE KANGO GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '5GG959855', 'BOUTON V GOLF 7 D', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '91117', 'BOUTON FEU DE TRESSE CLIO DCI', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'LED0123', 'LAMPE VEILLEUSE LED', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '12V21/5W', 'LAMPE II T20 2P', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '21301', 'LAMPE II 2P 12V', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '1P', '12', '2', 'LAMPE II 1P 12V', '', '', '', '', '', '', ''),
('', '', '', '', '', 'PLAQ', 'FICHE COSSE PLAQ', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'AST10030', 'FUSIBL 30A (50)', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '01403-24V', 'CENRAL CLEIGNOTON 24V 4F  A/M', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', '8200057321', 'BOUTON V CLIO MARON GF', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BSX12151518H', 'BAG DEM CHNAFA', '', '', '', '', '', '', '', '', ''),
('', '', '', '', '', 'BSX121515H', 'BAG DEM STD', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `produit_paramaitre`
--

CREATE TABLE `produit_paramaitre` (
  `désignation` tinyint(1) NOT NULL DEFAULT 1,
  `code_barre` tinyint(1) NOT NULL DEFAULT 1,
  `famille` tinyint(1) NOT NULL DEFAULT 1,
  `unite` tinyint(1) NOT NULL DEFAULT 0,
  `marque` tinyint(1) NOT NULL DEFAULT 0,
  `étagére` tinyint(1) NOT NULL DEFAULT 0,
  `remarque` tinyint(1) NOT NULL DEFAULT 0,
  `prix_achat` tinyint(1) NOT NULL DEFAULT 1,
  `prix_vente_detail` tinyint(1) NOT NULL DEFAULT 1,
  `prix_vente_gros` tinyint(1) NOT NULL DEFAULT 0,
  `prix_special` tinyint(1) NOT NULL DEFAULT 0,
  `quantité` tinyint(1) NOT NULL DEFAULT 1,
  `stock_alert` tinyint(1) NOT NULL DEFAULT 0,
  `jour_alert` tinyint(1) NOT NULL DEFAULT 0,
  `tva` tinyint(1) NOT NULL DEFAULT 0,
  `date_premption` tinyint(1) NOT NULL DEFAULT 1,
  `date_achat` tinyint(1) NOT NULL DEFAULT 0,
  `taille` tinyint(1) NOT NULL DEFAULT 0,
  `pointure` tinyint(1) NOT NULL DEFAULT 0,
  `couleur` tinyint(1) NOT NULL DEFAULT 0,
  `saisie_par` tinyint(1) NOT NULL DEFAULT 1,
  `nbre_produit_packet` tinyint(1) NOT NULL DEFAULT 0,
  `prix_vente_packet` tinyint(1) NOT NULL DEFAULT 0,
  `code_bare_packet` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `produit_paramaitre`
--

INSERT INTO `produit_paramaitre` (`désignation`, `code_barre`, `famille`, `unite`, `marque`, `étagére`, `remarque`, `prix_achat`, `prix_vente_detail`, `prix_vente_gros`, `prix_special`, `quantité`, `stock_alert`, `jour_alert`, `tva`, `date_premption`, `date_achat`, `taille`, `pointure`, `couleur`, `saisie_par`, `nbre_produit_packet`, `prix_vente_packet`, `code_bare_packet`) VALUES
(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `retour_endommagé`
--

CREATE TABLE `retour_endommagé` (
  `nom_prénom_client` varchar(255) DEFAULT NULL,
  `date_retour` date DEFAULT NULL,
  `désignation` varchar(255) DEFAULT NULL,
  `quantité` int(255) DEFAULT 0,
  `prix_achat` double DEFAULT 0,
  `prix_vente` double DEFAULT 0,
  `montant_versé` double DEFAULT 0,
  `remise` double DEFAULT 0,
  `num_bon_livraison` int(255) DEFAULT NULL,
  `heure_retour` varchar(222) DEFAULT NULL,
  `id_retour` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `salaire_employe`
--

CREATE TABLE `salaire_employe` (
  `id_salaire` int(255) NOT NULL,
  `nom_prenom` varchar(100) DEFAULT '',
  `type_versement` varchar(255) DEFAULT NULL,
  `id_employe` varchar(255) DEFAULT NULL,
  `date_versement` date DEFAULT NULL,
  `montant` double UNSIGNED NOT NULL DEFAULT 0,
  `remarque` varchar(200) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `salaire_employe`
--

INSERT INTO `salaire_employe` (`id_salaire`, `nom_prenom`, `type_versement`, `id_employe`, `date_versement`, `montant`, `remarque`) VALUES
(1, 'sahraoui', 'prime', 'E1', '2020-11-11', 22, 'mppppppppppppppllllllll'),
(2, 'sahraoui', 'salaire', 'E1', '2020-11-11', 2344, 'tttttttttt'),
(3, 'salaire', 'salaire', NULL, '2020-11-12', 22, 'eeeeeeeeeeeemmmmmmmmmmmmm'),
(4, 'sahraoui', 'prime', 'E1', '2020-11-12', 3333, 'REGLAGE DES PIECE AUTO'),
(5, 'sahraoui', 'salaire', 'E1', '2020-11-12', 555, 'UU'),
(6, 'KKKK', 'salaire', 'E2', '2020-11-14', 4555, 'FFFFFF'),
(7, 'KKKK', 'salaire', 'E2', '2020-11-14', 77788, 'HHJJSJS'),
(8, 'OMAR HA', 'salaire', 'E1', '2020-11-14', 566666, 'JJSJQJSJQS'),
(9, 'OMAR HA', 'prime', 'E1', '2020-11-14', 788888, 'MODU');

-- --------------------------------------------------------

--
-- Structure de la table `sqlite_sequence`
--

CREATE TABLE `sqlite_sequence` (
  `name` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `taille`
--

CREATE TABLE `taille` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `taille`
--

INSERT INTO `taille` (`ID`, `valeur`) VALUES
(2, 'm'),
(3, 's');

-- --------------------------------------------------------

--
-- Structure de la table `typeclient`
--

CREATE TABLE `typeclient` (
  `type` varchar(222) DEFAULT NULL,
  `id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `typeclient`
--

INSERT INTO `typeclient` (`type`, `id`) VALUES
('detail', 19),
('gros', 20),
('demi gros', 21);

-- --------------------------------------------------------

--
-- Structure de la table `typedepence`
--

CREATE TABLE `typedepence` (
  `id_depence` int(255) NOT NULL,
  `depence` varchar(111) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `typedepence`
--

INSERT INTO `typedepence` (`id_depence`, `depence`) VALUES
(4, 'eau'),
(5, 'electricite');

-- --------------------------------------------------------

--
-- Structure de la table `typeemploye`
--

CREATE TABLE `typeemploye` (
  `id_fonction` int(255) NOT NULL,
  `type` varchar(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Déchargement des données de la table `typeemploye`
--

INSERT INTO `typeemploye` (`id_fonction`, `type`) VALUES
(1, 'lll'),
(5, 'jjj'),
(6, ''),
(7, 'ttttt');

-- --------------------------------------------------------

--
-- Structure de la table `unites`
--

CREATE TABLE `unites` (
  `ID` int(11) NOT NULL,
  `valeur` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `unites`
--

INSERT INTO `unites` (`ID`, `valeur`) VALUES
(2, 'kg'),
(5, 'piece'),
(7, 'mg'),
(8, 'g'),
(9, 'ml'),
(10, 'l'),
(11, 'll');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(2552) NOT NULL,
  `nom_prénom` varchar(255) DEFAULT NULL,
  `autorisation1` int(11) NOT NULL DEFAULT 1,
  `autorisation2` int(11) NOT NULL DEFAULT 1,
  `autorisation3` int(11) NOT NULL DEFAULT 0,
  `autorisation4` int(11) NOT NULL DEFAULT 1,
  `autorisation5` int(11) NOT NULL DEFAULT 0,
  `autorisation6` int(11) NOT NULL DEFAULT 1,
  `autorisation7` int(11) NOT NULL DEFAULT 0,
  `autorisation8` int(11) NOT NULL DEFAULT 0,
  `autorisation9` int(11) NOT NULL DEFAULT 0,
  `autorisation10` int(11) NOT NULL DEFAULT 0,
  `autorisation11` int(11) NOT NULL DEFAULT 0,
  `autorisation12` int(11) NOT NULL DEFAULT 0,
  `autorisation13` int(11) NOT NULL DEFAULT 1,
  `autorisation14` int(11) NOT NULL DEFAULT 1,
  `autorisation15` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`username`, `password`, `nom_prénom`, `autorisation1`, `autorisation2`, `autorisation3`, `autorisation4`, `autorisation5`, `autorisation6`, `autorisation7`, `autorisation8`, `autorisation9`, `autorisation10`, `autorisation11`, `autorisation12`, `autorisation13`, `autorisation14`, `autorisation15`) VALUES
('admin', '1234', 'admin', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
('dd', '123', 'sah', 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `vente`
--

CREATE TABLE `vente` (
  `date_vente` date DEFAULT NULL,
  `nom_prénom_client` varchar(255) DEFAULT NULL,
  `TVA` float DEFAULT 0,
  `désignation` varchar(255) DEFAULT NULL,
  `prix_achat` double DEFAULT 0,
  `prix_vente` double DEFAULT 0,
  `quantité_vente` float NOT NULL DEFAULT 0,
  `montantTTC` double DEFAULT 0,
  `montantHT` double DEFAULT 0,
  `id_vente` int(255) NOT NULL,
  `temp_vente` varchar(222) DEFAULT NULL,
  `user` varchar(222) DEFAULT NULL,
  `id_produit` int(11) DEFAULT NULL,
  `idc` int(10) NOT NULL DEFAULT 0,
  `somme_versé` double NOT NULL DEFAULT 0,
  `remise` double NOT NULL DEFAULT 0,
  `num_bon` int(11) NOT NULL DEFAULT 0,
  `Message` varchar(250) NOT NULL DEFAULT '',
  `rendu` double NOT NULL DEFAULT 0,
  `code` varchar(14) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `vente`
--

INSERT INTO `vente` (`date_vente`, `nom_prénom_client`, `TVA`, `désignation`, `prix_achat`, `prix_vente`, `quantité_vente`, `montantTTC`, `montantHT`, `id_vente`, `temp_vente`, `user`, `id_produit`, `idc`, `somme_versé`, `remise`, `num_bon`, `Message`, `rendu`, `code`) VALUES
('2023-09-29', 'Passager', 19, 'simbel', 100, 150, 5, 892.5, 750, 230, '21:27:40', 'admin', 159, 0, 0, 0, 1, '', 0, '6482737387498'),
('2023-09-29', 'Passager', 19, 'prod3', 0, 100, 7, 833, 700, 231, '21:27:40', 'admin', 138, 0, 0, 0, 1, '', 0, '6482737387498');

-- --------------------------------------------------------

--
-- Structure de la table `versement_client`
--

CREATE TABLE `versement_client` (
  `num_versement` int(222) NOT NULL,
  `nom_prénom_client` varchar(255) DEFAULT NULL,
  `date_versement` date DEFAULT NULL,
  `montant_versé` double DEFAULT 0,
  `id_c` int(255) DEFAULT 0,
  `etat` varchar(10) NOT NULL,
  `num_bon_réception` int(11) NOT NULL DEFAULT 0,
  `remarque` varchar(100) NOT NULL,
  `regler_par` varchar(50) NOT NULL,
  `ancien_dette` double NOT NULL DEFAULT 0,
  `rendu` double NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `versement_client`
--

INSERT INTO `versement_client` (`num_versement`, `nom_prénom_client`, `date_versement`, `montant_versé`, `id_c`, `etat`, `num_bon_réception`, `remarque`, `regler_par`, `ancien_dette`, `rendu`) VALUES
(291, 'rais hicahmgggggggggggggggg', '2023-09-25', 1000, 16, 'Annuler', 3, '', 'admin', 750, 0),
(292, 'Passager', '2023-09-26', 0, 0, 'Annuler', 4, '', 'admin', 0, 0),
(293, 'Passager', '2023-09-26', 1200, 0, 'Annuler', 5, '', 'admin', 0, 0),
(294, 'Passager', '2023-09-28', 0, 0, 'Annuler', 6, '', 'admin', 0, 0),
(295, 'Passager', '2023-09-29', 0, 0, 'Annuler', 1, '', 'admin', 0, 0),
(296, 'Passager', '2023-09-29', 0, 0, 'valider', 1, '', 'admin', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `versement_fournisseur`
--

CREATE TABLE `versement_fournisseur` (
  `num_versement` int(222) NOT NULL,
  `nom_prénom_fournisseur` varchar(255) DEFAULT NULL,
  `date_versement` date DEFAULT NULL,
  `montant_versé` double DEFAULT 0,
  `id_f` int(255) DEFAULT NULL,
  `etat` varchar(10) NOT NULL,
  `num_bon_réception` int(11) NOT NULL,
  `remarque` varchar(100) NOT NULL,
  `regler_par` varchar(50) NOT NULL,
  `ancien_dette` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `achat`
--
ALTER TABLE `achat`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `catégorie_produits`
--
ALTER TABLE `catégorie_produits`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_c`);

--
-- Index pour la table `codebarre`
--
ALTER TABLE `codebarre`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`),
  ADD KEY `const1` (`id_produit`);

--
-- Index pour la table `couleur`
--
ALTER TABLE `couleur`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `dépence`
--
ALTER TABLE `dépence`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`id_e`);

--
-- Index pour la table `famille`
--
ALTER TABLE `famille`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id_f`);

--
-- Index pour la table `images_article`
--
ALTER TABLE `images_article`
  ADD PRIMARY KEY (`image_id`);

--
-- Index pour la table `inventaire`
--
ALTER TABLE `inventaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `marques`
--
ALTER TABLE `marques`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `paramaitres`
--
ALTER TABLE `paramaitres`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `pointure`
--
ALTER TABLE `pointure`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id_produit`),
  ADD KEY `référence` (`référence`),
  ADD KEY `référence_2` (`référence`);

--
-- Index pour la table `retour_endommagé`
--
ALTER TABLE `retour_endommagé`
  ADD PRIMARY KEY (`id_retour`);

--
-- Index pour la table `salaire_employe`
--
ALTER TABLE `salaire_employe`
  ADD PRIMARY KEY (`id_salaire`);

--
-- Index pour la table `sqlite_sequence`
--
ALTER TABLE `sqlite_sequence`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `taille`
--
ALTER TABLE `taille`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `typeclient`
--
ALTER TABLE `typeclient`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `typedepence`
--
ALTER TABLE `typedepence`
  ADD PRIMARY KEY (`id_depence`);

--
-- Index pour la table `typeemploye`
--
ALTER TABLE `typeemploye`
  ADD PRIMARY KEY (`id_fonction`);

--
-- Index pour la table `unites`
--
ALTER TABLE `unites`
  ADD PRIMARY KEY (`ID`) USING BTREE;

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `vente`
--
ALTER TABLE `vente`
  ADD PRIMARY KEY (`id_vente`);

--
-- Index pour la table `versement_client`
--
ALTER TABLE `versement_client`
  ADD PRIMARY KEY (`num_versement`);

--
-- Index pour la table `versement_fournisseur`
--
ALTER TABLE `versement_fournisseur`
  ADD PRIMARY KEY (`num_versement`),
  ADD KEY `const2` (`num_bon_réception`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `achat`
--
ALTER TABLE `achat`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=337;

--
-- AUTO_INCREMENT pour la table `catégorie_produits`
--
ALTER TABLE `catégorie_produits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `id_c` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `codebarre`
--
ALTER TABLE `codebarre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=236;

--
-- AUTO_INCREMENT pour la table `couleur`
--
ALTER TABLE `couleur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `dépence`
--
ALTER TABLE `dépence`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `employe`
--
ALTER TABLE `employe`
  MODIFY `id_e` int(222) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `famille`
--
ALTER TABLE `famille`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id_f` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT pour la table `images_article`
--
ALTER TABLE `images_article`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `inventaire`
--
ALTER TABLE `inventaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `marques`
--
ALTER TABLE `marques`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT pour la table `pointure`
--
ALTER TABLE `pointure`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id_produit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=160;

--
-- AUTO_INCREMENT pour la table `retour_endommagé`
--
ALTER TABLE `retour_endommagé`
  MODIFY `id_retour` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `salaire_employe`
--
ALTER TABLE `salaire_employe`
  MODIFY `id_salaire` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `sqlite_sequence`
--
ALTER TABLE `sqlite_sequence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `taille`
--
ALTER TABLE `taille`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `typeclient`
--
ALTER TABLE `typeclient`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `typedepence`
--
ALTER TABLE `typedepence`
  MODIFY `id_depence` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `typeemploye`
--
ALTER TABLE `typeemploye`
  MODIFY `id_fonction` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `unites`
--
ALTER TABLE `unites`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `vente`
--
ALTER TABLE `vente`
  MODIFY `id_vente` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=232;

--
-- AUTO_INCREMENT pour la table `versement_client`
--
ALTER TABLE `versement_client`
  MODIFY `num_versement` int(222) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=297;

--
-- AUTO_INCREMENT pour la table `versement_fournisseur`
--
ALTER TABLE `versement_fournisseur`
  MODIFY `num_versement` int(222) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=177;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `codebarre`
--
ALTER TABLE `codebarre`
  ADD CONSTRAINT `const1` FOREIGN KEY (`id_produit`) REFERENCES `produit` (`id_produit`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
