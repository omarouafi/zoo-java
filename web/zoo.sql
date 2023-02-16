-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 23 oct. 2020 à 11:33
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE DATABASE IF NOT EXISTS `zoo` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `zoo`;

--
-- Base de données : `zoo`
--

-- --------------------------------------------------------

--
-- Structure de la table `animal`
--
DROP TABLE IF EXISTS `animal`;

CREATE TABLE `animal` (
  `idAnimal` tinyint(4) NOT NULL,
  `codeAnimal` varchar(20) DEFAULT NULL,
  `nom` varchar(20) DEFAULT NULL,
  `age` tinyint(4) DEFAULT 0,
  `poids` float DEFAULT 0,
  `x` int(3) NOT NULL,
  `y` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `animal`
--

INSERT INTO `animal` (`idAnimal`, `codeAnimal`, `nom`, `age`, `poids`, `x`, `y`) VALUES
(1, 'Lion', 'clarence', 10, 170.4, 800, 400),
(2, 'Gazelle', 'GAGAG', 5, 135.2, 200, 400),
(3, 'Singe', 'chita', 4, 38, 500, 480),
(4, NULL, NULL, 0, 0, 300, 300),
(5, 'Gazelle', 'Beep Beep', 5, 135.2, 700, 230);

-- --------------------------------------------------------

--
-- Structure de la table `gazelle`
--

DROP TABLE IF EXISTS `gazelle`;

CREATE TABLE `gazelle` (
  `id` tinyint(4) NOT NULL,
  `idAnimal` tinyint(4) NOT NULL,
  `lgCornes` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `gazelle`
--

INSERT INTO `gazelle` (`id`, `idAnimal`, `lgCornes`) VALUES
(1, 2, 34),
(2, 5, 23);

-- --------------------------------------------------------

--
-- Structure de la table `menu`
--

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `url` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `menu`
--

INSERT INTO `menu` (`id`, `url`, `description`) VALUES
(1, '../controleur/controleur.php?action=manger', 'nourrir animaux'),
(2, '#\" onclick=\"document.fzoo.submit();', 'dévorer'),
(3, '../controleur/controleur.php?action=entrer', 'faire entrer un visiteur'),
(4, '../controleur/controleur.php?action=sortir', 'faire sortir un visiteur'),
(5, '../controleur/controleur.php?action=fermer', 'fermer le zoo');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`idAnimal`);

--
-- Index pour la table `gazelle`
--
ALTER TABLE `gazelle`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `animal`
--
ALTER TABLE `animal`
  MODIFY `idAnimal` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `gazelle`
--
ALTER TABLE `gazelle`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
