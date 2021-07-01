-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : jeu. 01 juil. 2021 à 12:18
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `seoladh`
--
CREATE DATABASE IF NOT EXISTS `seoladh` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `seoladh`;

-- --------------------------------------------------------

--
-- Structure de la table `contacts`
--

CREATE TABLE `contacts` (
  `id` int(11) NOT NULL,
  `nom` varchar(32) DEFAULT NULL,
  `prenom` varchar(32) DEFAULT NULL,
  `dateNaissance` varchar(32) DEFAULT NULL,
  `categorie` varchar(32) DEFAULT NULL,
  `email1` varchar(32) DEFAULT NULL,
  `email2` varchar(32) DEFAULT NULL,
  `tel1` varchar(32) DEFAULT NULL,
  `tel2` varchar(32) DEFAULT NULL,
  `adresse1` text,
  `adresse2` text,
  `codepostal` varchar(5) DEFAULT NULL,
  `ville` varchar(32) DEFAULT NULL,
  `pays` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `contacts`
--

INSERT INTO `contacts` (`id`, `nom`, `prenom`, `dateNaissance`, `categorie`, `email1`, `email2`, `tel1`, `tel2`, `adresse1`, `adresse2`, `codepostal`, `ville`, `pays`) VALUES
(1, 'superAdmin', 'superAdmin', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(2, 'admin', 'admin', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(3, 'modo', 'modo', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(4, 'client', 'client', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(5, 'guest', 'guest', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `identifiant` varchar(32) NOT NULL,
  `motdepasse` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `identifiant`, `motdepasse`) VALUES
(1, 'superAdmin', 'superAdmin'),
(2, 'admin', 'admin'),
(3, 'modo', 'modo'),
(4, 'client', 'client'),
(5, 'guest', 'guest');

-- --------------------------------------------------------

--
-- Structure de la table `user_and_contact`
--

CREATE TABLE `user_and_contact` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_and_contact`
--

INSERT INTO `user_and_contact` (`id`, `user_id`, `contact_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `contacts`
--
ALTER TABLE `contacts`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_and_contact`
--
ALTER TABLE `user_and_contact`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_and_contact_ibfk_1` (`user_id`),
  ADD KEY `user_and_contact_ibfk_2` (`contact_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `user_and_contact`
--
ALTER TABLE `user_and_contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `user_and_contact`
--
ALTER TABLE `user_and_contact`
  ADD CONSTRAINT `user_and_contact_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `user_and_contact_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
