USE [master]
GO
/****** Object:  Database [SkillSwapHub]    Script Date: 27/03/2025 7:32:41 AM ******/
CREATE DATABASE [SkillSwapHub]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SkillSwapHub', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\SkillSwapHub.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SkillSwapHub_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\SkillSwapHub_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [SkillSwapHub] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SkillSwapHub].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SkillSwapHub] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SkillSwapHub] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SkillSwapHub] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SkillSwapHub] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SkillSwapHub] SET ARITHABORT OFF 
GO
ALTER DATABASE [SkillSwapHub] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SkillSwapHub] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SkillSwapHub] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SkillSwapHub] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SkillSwapHub] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SkillSwapHub] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SkillSwapHub] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SkillSwapHub] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SkillSwapHub] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SkillSwapHub] SET  ENABLE_BROKER 
GO
ALTER DATABASE [SkillSwapHub] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SkillSwapHub] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SkillSwapHub] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SkillSwapHub] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SkillSwapHub] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SkillSwapHub] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SkillSwapHub] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SkillSwapHub] SET RECOVERY FULL 
GO
ALTER DATABASE [SkillSwapHub] SET  MULTI_USER 
GO
ALTER DATABASE [SkillSwapHub] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SkillSwapHub] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SkillSwapHub] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SkillSwapHub] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SkillSwapHub] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SkillSwapHub] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'SkillSwapHub', N'ON'
GO
ALTER DATABASE [SkillSwapHub] SET QUERY_STORE = ON
GO
ALTER DATABASE [SkillSwapHub] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [SkillSwapHub]
GO
/****** Object:  Table [dbo].[Notifications]    Script Date: 27/03/2025 7:32:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notifications](
	[notification_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[message] [nvarchar](255) NOT NULL,
	[is_read] [bit] NULL,
	[created_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[notification_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ratings]    Script Date: 27/03/2025 7:32:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ratings](
	[rating_id] [int] IDENTITY(1,1) NOT NULL,
	[swap_id] [int] NOT NULL,
	[rater_id] [int] NOT NULL,
	[ratee_id] [int] NOT NULL,
	[rating_score] [int] NULL,
	[comment] [text] NULL,
	[created_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[rating_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Skills]    Script Date: 27/03/2025 7:32:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skills](
	[skill_id] [int] IDENTITY(1,1) NOT NULL,
	[skill_name] [varchar](100) NOT NULL,
	[category] [nchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[skill_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[skill_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SwapRequest]    Script Date: 27/03/2025 7:32:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SwapRequest](
	[request_id] [int] IDENTITY(1,1) NOT NULL,
	[sender_id] [int] NOT NULL,
	[receiver_id] [int] NOT NULL,
	[skill_requested_id] [int] NOT NULL,
	[skill_offered_id] [int] NULL,
	[status] [nvarchar](10) NULL,
	[request_date] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[request_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 27/03/2025 7:32:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[password_hash] [varchar](255) NOT NULL,
	[bio] [text] NULL,
	[profile_picture_url] [text] NULL,
	[location] [varchar](100) NULL,
	[created_at] [datetime] NULL,
	[rating] [float] NULL,
	[fullName] [varchar](50) NULL,
	[role] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserSkills]    Script Date: 27/03/2025 7:32:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserSkills](
	[user_skill_id] [int] IDENTITY(1,1) NOT NULL,
	[user_id] [int] NOT NULL,
	[skill_id] [int] NOT NULL,
	[type] [varchar](10) NULL,
	[proficiency_level] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[user_skill_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Notifications] ADD  DEFAULT ((0)) FOR [is_read]
GO
ALTER TABLE [dbo].[Notifications] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[Ratings] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[SwapRequest] ADD  DEFAULT ('pending') FOR [status]
GO
ALTER TABLE [dbo].[SwapRequest] ADD  DEFAULT (getdate()) FOR [request_date]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT (getdate()) FOR [created_at]
GO
ALTER TABLE [dbo].[Users] ADD  DEFAULT ((0)) FOR [rating]
GO
ALTER TABLE [dbo].[Users] ADD  CONSTRAINT [DF_Users_Role]  DEFAULT ('member') FOR [role]
GO
ALTER TABLE [dbo].[Notifications]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Ratings]  WITH CHECK ADD FOREIGN KEY([ratee_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Ratings]  WITH CHECK ADD FOREIGN KEY([rater_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[SwapRequest]  WITH CHECK ADD  CONSTRAINT [FK_Receiver] FOREIGN KEY([receiver_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[SwapRequest] CHECK CONSTRAINT [FK_Receiver]
GO
ALTER TABLE [dbo].[SwapRequest]  WITH CHECK ADD  CONSTRAINT [FK_Sender] FOREIGN KEY([sender_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[SwapRequest] CHECK CONSTRAINT [FK_Sender]
GO
ALTER TABLE [dbo].[SwapRequest]  WITH CHECK ADD  CONSTRAINT [FK_SkillOffered] FOREIGN KEY([skill_offered_id])
REFERENCES [dbo].[Skills] ([skill_id])
GO
ALTER TABLE [dbo].[SwapRequest] CHECK CONSTRAINT [FK_SkillOffered]
GO
ALTER TABLE [dbo].[SwapRequest]  WITH CHECK ADD  CONSTRAINT [FK_SkillRequested] FOREIGN KEY([skill_requested_id])
REFERENCES [dbo].[Skills] ([skill_id])
GO
ALTER TABLE [dbo].[SwapRequest] CHECK CONSTRAINT [FK_SkillRequested]
GO
ALTER TABLE [dbo].[UserSkills]  WITH CHECK ADD FOREIGN KEY([skill_id])
REFERENCES [dbo].[Skills] ([skill_id])
GO
ALTER TABLE [dbo].[UserSkills]  WITH CHECK ADD FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([user_id])
GO
ALTER TABLE [dbo].[Ratings]  WITH CHECK ADD CHECK  (([rating_score]>=(1) AND [rating_score]<=(5)))
GO
ALTER TABLE [dbo].[UserSkills]  WITH CHECK ADD CHECK  (([proficiency_level]='Expert' OR [proficiency_level]='Intermediate' OR [proficiency_level]='Beginner'))
GO
ALTER TABLE [dbo].[UserSkills]  WITH CHECK ADD CHECK  (([type]='wanted' OR [type]='offered'))
GO
USE [master]
GO
ALTER DATABASE [SkillSwapHub] SET  READ_WRITE 
GO
