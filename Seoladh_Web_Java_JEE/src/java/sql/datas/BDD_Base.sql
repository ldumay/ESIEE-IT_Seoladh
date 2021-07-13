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
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `identifiant` varchar(32) NOT NULL,
  `motdepasse` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `users_and_contacts`
--

CREATE TABLE `users_and_contacts` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `lists_contacts`
--

CREATE TABLE `lists_contacts` (
  `id` int(11) NOT NULL,
  `nom` varchar(32) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `lists_contacts_and_contacts`
--

CREATE TABLE `lists_contacts_and_contacts` (
  `id` int(11) NOT NULL,
  `list_contacts_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `logs`
--

CREATE TABLE `logs` (
  `id` int(11) NOT NULL,
  `date` DATE NOT NULL,
  `ip` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `users_and_logs`
--

CREATE TABLE `users_and_logs` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `log_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Déchargement des données de la table `contacts`
--

INSERT INTO `contacts` (`id`, `nom`, `prenom`, `dateNaissance`, `categorie`, `email1`, `email2`, `tel1`, `tel2`, `adresse1`, `adresse2`, `codepostal`, `ville`, `pays`) VALUES
(1, 'superAdmin', 'superAdmin', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(2, 'admin', 'admin', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(3, 'modo', 'modo', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(4, 'client', 'client', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(5, 'guest', 'guest', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(6, 'Contact', 'Numero 1', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(7, 'Contact', 'Numero 2', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(8, 'Contact', 'Numero 3', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(9, 'Contact', 'Numero 4', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(10, 'Contact', 'Numero 5', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(11, 'Contact', 'Numero 6', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(12, 'Contact', 'Numero 7', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(13, 'Contact', 'Numero 8', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(14, 'Contact', 'Numero 9', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(15, 'Contact', 'Numero 10', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(16, 'Contact', 'Numero 11', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(17, 'Contact', 'Numero 12', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(18, 'Contact', 'Numero 13', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(19, 'Contact', 'Numero 14', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(20, 'Contact', 'Numero 15', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(21, 'Contact', 'Numero 16', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(22, 'Contact', 'Numero 17', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(23, 'Contact', 'Numero 18', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(24, 'Contact', 'Numero 19', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(25, 'Contact', 'Numero 20', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(26, 'Contact', 'Numero 21', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(27, 'Contact', 'Numero 22', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(28, 'Contact', 'Numero 23', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(29, 'Contact', 'Numero 24', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(30, 'Contact', 'Numero 25', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(31, 'Contact', 'Numero 26', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(32, 'Contact', 'Numero 27', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(33, 'Contact', 'Numero 28', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(34, 'Contact', 'Numero 29', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(35, 'Contact', 'Numero 30', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(36, 'Contact', 'Numero 31', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(37, 'Contact', 'Numero 32', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(38, 'Contact', 'Numero 33', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(39, 'Contact', 'Numero 34', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France'),
(40, 'Contact', 'Numero 35', '01/07/2000', NULL, 'mail.one@mail.com', 'mail.one@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France');

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `identifiant`, `motdepasse`) VALUES
(1, 'superAdmin', 'superAdmin'),
(2, 'admin', 'admin'),
(3, 'modo', 'modo'),
(4, 'client', 'client'),
(5, 'guest', 'guest');

--
-- Déchargement des données de la table `users_and_contacts`
--

INSERT INTO `users_and_contacts` (`id`, `user_id`, `contact_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

--
-- Déchargement des données de la table `lists_contacts`
--

INSERT INTO `lists_contacts` (`id`, `nom`, `description`) VALUES
(1, "Liste 1", "Ceci est une description.");

--
-- Déchargement des données de la table `lists_contacts_and_contacts`
--

INSERT INTO `lists_contacts_and_contacts` (`id`, `list_contacts_id`, `contact_id`) VALUES
(1, 1, 6),
(2, 1, 7),
(3, 1, 8),
(4, 1, 9),
(5, 1, 10),
(6, 1, 11),
(7, 1, 12),
(8, 1, 13),
(9, 1, 14),
(10, 1, 15),
(11, 1, 16),
(12, 1, 17),
(13, 1, 18),
(14, 1, 19),
(15, 1, 20);

--
-- Déchargement des données de la table `logs`
--

INSERT INTO `logs` (`id`, `date`, `ip`) VALUES
(1, "2021-01-01", "127.0.0.1"),
(2, "2021-01-01", "127.0.0.1"),
(3, "2021-01-01", "127.0.0.1"),
(4, "2021-01-01", "127.0.0.1"),
(5, "2021-01-01", "127.0.0.1");

--
-- Déchargement des données de la table `users_and_logs`
--

INSERT INTO `users_and_logs` (`id`, `user_id`, `log_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5);

-- --------------------------------------------------------

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
-- Index pour la table `users_and_contacts`
--
ALTER TABLE `users_and_contacts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_and_contact_ibfk_1` (`user_id`),
  ADD KEY `user_and_contact_ibfk_2` (`contact_id`);

--
-- Index pour la table `lists_contacts`
--
ALTER TABLE `lists_contacts`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `lists_contacts_and_contacts`
--
ALTER TABLE `lists_contacts_and_contacts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `lists_contacts_and_contacts_ibfk_1` (`list_contacts_id`),
  ADD KEY `lists_contacts_and_contacts_ibfk_2` (`contact_id`);

--
-- Index pour la table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users_and_logs`
--
ALTER TABLE `users_and_logs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `users_and_logs_ibfk_1` (`user_id`),
  ADD KEY `users_and_logs_ibfk_2` (`log_id`);

-- --------------------------------------------------------

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contacts`
--
ALTER TABLE `contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `users_and_contacts`
--
ALTER TABLE `users_and_contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `lists_contacts`
--
ALTER TABLE `lists_contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT pour la table `lists_contacts_and_contacts`
--
ALTER TABLE `lists_contacts_and_contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `logs`
--
ALTER TABLE `logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `users_and_logs`
--
ALTER TABLE `users_and_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

-- --------------------------------------------------------

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `users_and_contacts`
--
ALTER TABLE `users_and_contacts`
  ADD CONSTRAINT `user_and_contacts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `user_and_contacts_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`);

--
-- Contraintes pour la table `lists_contacts_and_contacts`
--
ALTER TABLE `lists_contacts_and_contacts`
  ADD CONSTRAINT `lists_contacts_and_contacts_ibfk_1` FOREIGN KEY (`list_contacts_id`) REFERENCES `lists_contacts` (`id`),
  ADD CONSTRAINT `lists_contacts_and_contacts_ibfk_2` FOREIGN KEY (`contact_id`) REFERENCES `contacts` (`id`);

--
-- Contraintes pour la table `users_and_logs`
--
ALTER TABLE `users_and_logs`
  ADD CONSTRAINT `users_and_logs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `users_and_logs_ibfk_2` FOREIGN KEY (`log_id`) REFERENCES `logs` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
