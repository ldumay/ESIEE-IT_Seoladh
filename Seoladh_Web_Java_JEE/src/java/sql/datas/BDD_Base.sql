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
  `pays` varchar(32) DEFAULT NULL,
  `blacklist` int(1) DEFAULT 0
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
  `description` varchar(64) DEFAULT NULL,
  `date_start` varchar(32) DEFAULT NULL,
  `date_end` varchar(32) DEFAULT NULL
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
-- Structure de la table `campaigns`
--

CREATE TABLE `campaigns` (
  `id` int(11) NOT NULL,
  `nom` varchar(32) DEFAULT NULL,
  `description` varchar(64) DEFAULT NULL,
  `date_start` varchar(32) DEFAULT NULL,
  `date_end` varchar(32) DEFAULT NULL,
  `statut` varchar(32) DEFAULT NULL,
  `message` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `campaigns_and_lists_contacts`
--

CREATE TABLE `campaigns_and_lists_contacts` (
  `id` int(11) NOT NULL,
  `campaigns_id` int(11) NOT NULL,
  `list_contacts_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `logs`
--

CREATE TABLE `logs` (
  `id` int(11) NOT NULL,
  `date` varchar(32) NOT NULL,
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

--
-- Structure de la table `admin_server`
--

CREATE TABLE `admin_server` (
  `id` int(11) NOT NULL,
  `nom_du_serveur` varchar(32) NOT NULL,
  `adresse_du_serveur` varchar(32) NOT NULL,
  `port_du_serveur` varchar(32) NOT NULL,
  `adresse_email_du_serveur` varchar(32) NOT NULL,
  `mot_de_passe_du_serveur` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `admin_roles`
--

CREATE TABLE `admin_roles` (
  `id` int(11) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `description` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Structure de la table `users_and_admin_roles`
--

CREATE TABLE `users_and_admin_roles` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `admin_roles_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Déchargement des données de la table `contacts`
--

INSERT INTO `contacts` (`id`, `nom`, `prenom`, `dateNaissance`, `categorie`, `email1`, `email2`, `tel1`, `tel2`, `adresse1`, `adresse2`, `codepostal`, `ville`, `pays`, `blacklist`) VALUES
(1, 'superAdmin', 'superAdmin', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 0),
(2, 'admin', 'admin', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 0),
(3, 'modo', 'modo', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 0),
(4, 'client', 'client', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 0),
(5, 'guest', 'guest', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 0),
(6, 'Contact', 'Numero 1', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(7, 'Contact', 'Numero 2', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(8, 'Contact', 'Numero 3', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(9, 'Contact', 'Numero 4', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(10, 'Contact', 'Numero 5', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(11, 'Contact', 'Numero 6', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(12, 'Contact', 'Numero 7', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(13, 'Contact', 'Numero 8', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(14, 'Contact', 'Numero 9', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(15, 'Contact', 'Numero 10', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(16, 'Contact', 'Numero 11', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(17, 'Contact', 'Numero 12', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(18, 'Contact', 'Numero 13', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(19, 'Contact', 'Numero 14', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(20, 'Contact', 'Numero 15', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(21, 'Contact', 'Numero 16', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(22, 'Contact', 'Numero 17', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(23, 'Contact', 'Numero 18', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(24, 'Contact', 'Numero 19', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(25, 'Contact', 'Numero 20', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(26, 'Contact', 'Numero 21', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(27, 'Contact', 'Numero 22', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(28, 'Contact', 'Numero 23', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(29, 'Contact', 'Numero 24', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(30, 'Contact', 'Numero 25', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(31, 'Contact', 'Numero 26', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(32, 'Contact', 'Numero 27', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(33, 'Contact', 'Numero 28', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(34, 'Contact', 'Numero 29', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 1),
(35, 'Contact', 'Numero 30', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 2),
(36, 'Contact', 'Numero 31', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 2),
(37, 'Contact', 'Numero 32', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 2),
(38, 'Contact', 'Numero 33', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 2),
(39, 'Contact', 'Numero 34', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 2),
(40, 'Contact', 'Numero 35', '2021-01-01', NULL, 'mail.one@mail.com', 'mail.two@mail.com', '00.00.00.00.00', '00.00.00.00.00', 'Adresse 1', 'Adresse 2', '95000', 'Cergy', 'France', 2);

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

INSERT INTO `lists_contacts` (`id`, `nom`, `description`, `date_start`, `date_end`) VALUES
(1, 'Liste 1', 'Ceci est une description.', '2021-01-01', '2021-01-05'),
(2, 'Liste 2', 'Ceci est une description.', '2021-01-06', '2021-01-10'),
(3, 'Liste 3', 'Ceci est une description.', '2021-01-11', '2021-01-15'),
(4, 'Liste 4', 'Ceci est une description.', '2021-01-16', '2021-01-20'),
(5, 'Liste 5', 'Ceci est une description.', '2021-01-21', '2021-01-25'),
(6, 'Liste 6', 'Ceci est une description.', '2021-01-26', '2021-01-30');

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
(10, 2, 15),
(11, 2, 16),
(12, 2, 17),
(13, 2, 18),
(14, 2, 19),
(15, 3, 20),
(16, 3, 21),
(17, 3, 22),
(18, 3, 23),
(19, 3, 24),
(20, 4, 25),
(21, 4, 26),
(22, 4, 27),
(23, 4, 28),
(24, 4, 29),
(25, 5, 30),
(26, 5, 31),
(27, 5, 32),
(28, 5, 33),
(29, 5, 34),
(30, 6, 35),
(31, 6, 36),
(32, 6, 37),
(33, 6, 38),
(34, 6, 39),
(35, 6, 40);

--
-- Déchargement des données de la table `logs`
--

INSERT INTO `logs` (`id`, `date`, `ip`) VALUES
(1, '2021-01-01', '127.0.0.1'),
(2, '2021-01-02', '127.0.0.1'),
(3, '2021-01-03', '127.0.0.1'),
(4, '2021-01-04', '127.0.0.1'),
(5, '2021-01-05', '127.0.0.1'),
(6, '2021-01-06', '127.0.0.1'),
(7, '2021-01-07', '127.0.0.1'),
(8, '2021-01-08', '127.0.0.1'),
(9, '2021-01-09', '127.0.0.1'),
(10, '2021-01-10', '127.0.0.1'),
(11, '2021-01-11', '127.0.0.1'),
(12, '2021-01-12', '127.0.0.1'),
(13, '2021-01-13', '127.0.0.1'),
(14, '2021-01-14', '127.0.0.1'),
(15, '2021-01-15', '127.0.0.1');

--
-- Déchargement des données de la table `users_and_logs`
--

INSERT INTO `users_and_logs` (`id`, `user_id`, `log_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(10, 1, 10),
(11, 1, 11),
(12, 1, 12),
(13, 1, 13),
(14, 1, 14),
(15, 1, 15);

--
-- Déchargement des données de la table `campaigns`
--
INSERT INTO `campaigns` (`id`, `nom`, `description`, `date_start`, `date_end`, `statut`, `message`) VALUES
(1, 'Campagne 1', 'Ceci est une description.', '2021-01-01', '2021-01-05', 'Envoyé', 'Bonjour,\r\n\r\nCeci est un message de Seoladh !\r\n\r\nCordialement,\r\nSeoladh Corporation.');

INSERT INTO `campaigns` (`id`, `nom`, `description`, `date_start`, `date_end`, `statut`) VALUES
(2, 'Campagne 2', 'Ceci est une description.', '2021-01-06', '2021-01-10', 'Annulé'),
(3, 'Campagne 3', 'Ceci est une description.', '2021-01-11', '2021-01-15', 'En attente'),
(4, 'Campagne 4', 'Ceci est une description.', '2021-01-16', '2021-01-20', 'En attente'),
(5, 'Campagne 5', 'Ceci est une description.', '2021-01-21', '2021-01-25', 'En attente');

--
-- Déchargement des données de la table `campaigns_and_lists_contacts`
--

INSERT INTO `campaigns_and_lists_contacts` (`id`, `campaigns_id`, `list_contacts_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

--
-- Déchargement des données de la table `admin_server`
--

INSERT INTO `admin_server` (`id`, `nom_du_serveur`, `adresse_du_serveur`, `port_du_serveur`, `adresse_email_du_serveur`, `mot_de_passe_du_serveur`) VALUES
(1, 'Serveur de test', '127.0.0.1', '007', 'mail@mail.com', 'password');

--
-- Déchargement des données de la table `admin_roles`
--

INSERT INTO `admin_roles` (`id`, `nom`, `description`) VALUES
(1, 'Super Administrateur', 'Description 1'),
(2, 'Administrateur', 'Description 2'),
(3, 'Modérateur', 'Description 3'),
(4, 'Client', 'Description 4'),
(5, 'Guest', 'Description 5');

--
-- Déchargement des données de la table `users_and_admin_roles`
--

INSERT INTO `users_and_admin_roles` (`id`, `user_id`, `admin_roles_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5);

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

--
-- Index pour la table `campaigns`
--
ALTER TABLE `campaigns`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `campaigns_and_lists_contacts`
--
ALTER TABLE `campaigns_and_lists_contacts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `campaigns_and_lists_contacts_ibfk_1` (`campaigns_id`),
  ADD KEY `campaigns_and_lists_contacts_ibfk_2` (`list_contacts_id`);

--
-- Index pour la table `admin_server`
--
ALTER TABLE `admin_server`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `admin_roles`
--
ALTER TABLE `admin_roles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users_and_admin_roles`
--
ALTER TABLE `users_and_admin_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `users_and_logs_ibfk_1` (`user_id`),
  ADD KEY `users_and_logs_ibfk_2` (`admin_roles_id`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `lists_contacts_and_contacts`
--
ALTER TABLE `lists_contacts_and_contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pour la table `logs`
--
ALTER TABLE `logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `users_and_logs`
--
ALTER TABLE `users_and_logs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `lists_contacts`
--
ALTER TABLE `campaigns`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `campaigns_and_lists_contacts`
--
ALTER TABLE `campaigns_and_lists_contacts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `admin_server`
--
ALTER TABLE `admin_server`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT pour la table `admin_roles`
--
ALTER TABLE `admin_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `users_and_admin_roles`
--
ALTER TABLE `users_and_admin_roles`
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

--
-- Contraintes pour la table `campaigns_and_lists_contacts`
--
ALTER TABLE `campaigns_and_lists_contacts`
  ADD CONSTRAINT `campaigns_and_lists_contacts_ibfk_1` FOREIGN KEY (`campaigns_id`) REFERENCES `campaigns` (`id`),
  ADD CONSTRAINT `campaigns_and_lists_contacts_ibfk_2` FOREIGN KEY (`list_contacts_id`) REFERENCES `lists_contacts` (`id`);

--
-- Contraintes pour la table `users_and_admin_roles`
--
ALTER TABLE `users_and_admin_roles`
  ADD CONSTRAINT `users_and_admin_roles_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `users_and_admin_roles_ibfk_2` FOREIGN KEY (`admin_roles_id`) REFERENCES `admin_roles` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
