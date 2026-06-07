-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 16 avr. 2024 à 11:16
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
-- Base de données : `utilisateurs`
--

-- --------------------------------------------------------

--
-- Structure de la table `serial`
--

CREATE TABLE `serial` (
  `id` int(11) NOT NULL,
  `serialnumber` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `serial`
--


-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(2552) NOT NULL,
  `nom_prénom` varchar(255) DEFAULT NULL,
  `etat` int(11) NOT NULL DEFAULT 1,
  `autorisation1` int(11) NOT NULL DEFAULT 0,
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
  `autorisation15` int(11) NOT NULL DEFAULT 0,
  `autorisation16` int(11) NOT NULL DEFAULT 0,
  `autorisation17` int(11) NOT NULL DEFAULT 0,
  `autorisation18` int(11) NOT NULL DEFAULT 0,
  `autorisation19` int(11) NOT NULL DEFAULT 0,
  `autorisation20` int(11) NOT NULL DEFAULT 0,
  `autorisation21` int(11) NOT NULL DEFAULT 0,
  `autorisation22` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`username`, `password`, `nom_prénom`, `autorisation1`, `autorisation2`, `autorisation3`, `autorisation4`, `autorisation5`, `autorisation6`, `autorisation7`, `autorisation8`, `autorisation9`, `autorisation10`, `autorisation11`, `autorisation12`, `autorisation13`, `autorisation14`, `autorisation15`, `autorisation16`, `autorisation17`, `autorisation18`, `autorisation19`, `autorisation20`, `autorisation21`, `autorisation22`) VALUES
('admin', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220', 'admin', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);


--
-- Index pour la table `serial`
--
ALTER TABLE `serial`
  ADD PRIMARY KEY (`id`);
  
--
-- AUTO_INCREMENT pour la table `serial`
--
ALTER TABLE `serial`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
