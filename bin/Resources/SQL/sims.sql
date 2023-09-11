-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3304
-- Thời gian đã tạo: Th9 09, 2023 lúc 03:34 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `sims`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `disable` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `gender` tinyint(1) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employees`
--

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `image` longblob NOT NULL,
  `status` tinyint(1) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `position_id` int(11) NOT NULL,
  `start_working` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `employees`
--

INSERT INTO `employees` (`employee_id`, `username`, `password`, `email`, `tel`, `address`, `image`, `status`, `token`, `position_id`, `start_working`) VALUES
(1, 'admin', '$2a$10$T0zL9XCOWwVgFdUJCUsnLOblUva2BCJQ8EoxvekUICl/ej9pcMsR2', 'thq130692@gmail.com', '0902518533', '405/39 Xo Viet Nghe Tinh', 0x89504e470d0a1a0a0000000d494844520000016800000168040300000088cb7ce60000001e504c544503537defeeeeffffff01437107395a647d8a355d739ba3a8e0dad6c1bfbef79a6e45000011834944415478daecddcd7bd3461a00f029a365d91b1e1aa0b7ce2c10e7a654928d6f491d93e4b63809901b89f9ea6d710a746f5d1158b86d155296ff76fd113b963492e67de7c3f1f3642ead795af9c778be35f30e11e3c46be3b4101fc925fa127d89be445fa22fd10b826635be58e86162b31ff88547f3cf5fdfecbdd8d80882c0dfd878b1f7eeebb778f0c717153df897dba72f48d81e78c928f9c40f828d3679f1f8532c2e209a09fec39b5e7bc24d251a0461632f31883efb273bfb73ecc7fad7dda04d4a521874dec583afd5fda2613283e6a7bdb64f2a120d1bfbff9ed6ce39a38578f32ca8248fcbc983c71722a705ffda0b88720a1aff9a3b9a89cfff681348a2e15ffe982f5af0376d9f005310eecf132d7ed80d0822059d647ee853cf27a844d79e303e1ff4db3641a7f0e558ed185dc7158d4c11718b5ee9f9442bd1c66be1187d2bd0340fbb9adf8453f48736d14f347c22dca1cd9887d5715fb8428b5343e681fa150a8d18d77e30661ee5b593498049f340fd4438402f19354fd476d1cb01319c82d7dc327aa5478ca746c2ada2ebbbbe7934ed24dc26fa570be6a19ad9438b3fd78895447fb186661fdac4520a1f5a42b3656be6813ab183aeef128b695cac4da32d55c269b1deb680664b01b19a82ae7134b3d1ab64fa98d834da72e11815904dd3aba64bd6cd8302f2841b9d04d4dbc4410a13936871e4bb40d3a63087664b6bc449f2bae6d0f51e71941acc149a9df8aed0f49521b4d53147c118441b2d8edc9927755117cd967ce252dd3581e63de234350ca0d9cd35b768ef501f5d779cd1e3664f0fcd7ef75da3e9355df40a25ce931feba11df62ba9acd65a35ad07640e2948742601ecbd3f0f34fd9b0e7a652e193dc8ea188f9e43d371de8060d1754ae694fc188b9e5b460fb2fa3b2c9af7c8dc5203896637fdf9a1e9210ecd9f9139a60738f45d7f9e68dac5a0d911996b6a62d0cbfe7cd13481a3d9173267f4161c5d0fe68c260183a2e7dade4d5b3de8aae90e997b8a387012b0ac3d9dd5ffa5bc3e10fd5eaf380ef750073408f42a464b80d05c63258c061bcf1fff6f38a5fefc666f23d0c8f13006a1357ac3f0eafeb8e2d4862fbc3f9df6f07f7fda85a019ba1ad2f0712a7b046a3bea6cafa88c5ec156c3b093e4b775d777db9ae543058d6ea48397b16c033d7f1ba09b6a7534f28572b83f1a69497e53ec5680481d8d1c2b9deda19236ae48354d54d1ec18850e7e1125cb421f51cfa4ebca68d4dc906e8bd2b52cdc2bdf48158d6a3b68a762018ea3b63f79891a9a1da3e674553be6915b02d615d13bc8ceab6aa91bf5f226525b35c5940ebaa9720e0e53acbd446912700ff1e82051d93d89da1670c055d08859387dc595f68b627adaa60aba8e281d1153dc998ba82e61ac80468c4abd2e5744df5d43547105f4174c0d57deb88dc8ea6d5e8dee21f242fde82fe2776cb04a3462b0342ed18a7ba0e1594dfb95e81bf0871e70001adea0d2ef78151a9e1321831cee45b4d551159ac3abf716ec283cbca27b71051a5e51681f768c1a5e69a693f202346284d7019efd46cce5b62bd0e0225dbc4c686e69332a47c3477883513af0943de23be2d2555378918ee087eec1bfa6d72d9d04c08bf43a1cfd3db6812a40ef20ba2b301a5e3ea232347c58dae08823a7e0e1cd70785a888617e91606fd1ede5297a06fc01b3ccca162f8f8e33e2f461fc11b3c54301070296c96a07d540d811fee05d7f78015a2e1d5ba85439fc0df1915a2c1656d54a41168cd2f4aa1dfeb65803a7a59ef27255a45cd8b7168bea6557966d1c847614203e0b247865e46752d2834b8260e870b5234bccdff191b1be40e7cf62c5f3585eff0389b0721a256c1c70b5bf249007cd6e2255834bcf9880a662ef0150f8645d7e1ab637234bc3f6ca0839ac1df457989148d986ae1d13b98fa934733f882580b8f06b779e427291afe06600b8f3ec6e490040d5fc55b77898e6468f8c87cb24700135d105e813c2641afc017a6bb2ed13491a0118fd141af21be2d8766d7114bf47834e285c315091abe6e4c350268220ae3b6040d6ff168ec14dd94a09f62871e28741df1964bb26a0a7f8aaf1320d047e4516e1280a81994bb45f773e8bb171fddcda1ef918b8e260739f4f1c5476f892cfa0481666ed1ad1c7ac72d9a23d0510e8dd8ca45633c1ad14e4f6677e7684e10e8048f46f48884c419346a8b581f8fc66c67f5fa1934ea215d3c1ab3159e66d1a887b8467733e8efc9c547939fd368c4fa41fe452a048dc9a4e12a420a7db208e85666d57447e3216e166b06a9c3d3930014dae5b2d8f98b8773346a6fb3cb05c8d1f765d06b9887385dea1da4ab710a5d47a1cfba28278beae72fd3ced13e2aa71dbebe981da1118df1cba4b547a0512dde74b043343aa8499b0747e35abc69174cb03b4067da3c041a770a6ffc865c174d190ecd7d13e81f914fe9e3d0c8c361f44a0a7d9d20ffea3834f28725d7f82c1a7b0ef83e0a8dac879377f113343686408443634fc36e1b418f768182d1c85e81904d3eb36a8a0e8b316a39c1e369f459e9d6ec24001fcbc3cd66c2f375f55934fac8b59b6d9b86d1980db2f8380b510a8d0f5ee4642bb21cfd14ff1c079bbecf6701a9d9381eed255034faf8ff747e47b0a75ba685fa1a07a2affbf81c32841ecceb81688d78f229744d034dfb30b44ea82463393d3d3aa388d689d112a65a0fa2f3a41882d68a194e53685fe7490700b45ea82473e8e90b1c1534d70a9564103d59ec5689bfad176299a6564db51e65f960f02c3a3509d043d387ca47b0fd0b83563eecce35837fa5d144f3618a61053efa26d16b9aead05e0087548fc84ca207730a05f491af8bae19450feb62155a3fa2bce19ca67ee5dd5906e26f7ba932fd54fb79b41397a3b9817bc6ae1a468fee9029417313b7d834526813c113bd57256833f78c45c6d124785588167f1a09de99469b89161bec1704a315a766028eda400fef0196c575adbf351424b599429f987928f13ab903fb42dcda3575b74a33b56afaaba1a71a0ea758301d3d431b0ccc7b1eb892e906aeac409f987bf0798850ae1b223497eea7d0bf13a369188675188c35341ba5f82c3cfc64b1e6479f2c42ba9242df5b08f4e460cd22a3ef2e06ba9b422f2f063a49a1eb8b818ed3e8b545407b2c85bebd10689a46b3de22a0a3ccb6cd9d4544ef2e027a33b3d7f46411d0adcc0ec8bf2f027a3583beb308e8f5ccd1be45e8c727dbf2a668f3fdb8f99ba4bc7e166db077198cfda7a96d701ae0251974dd54fe06e183e77b8fbf7d1acc106bb73fbfdb7bf4ac6d6cc6c5326861a44ba41bfef33fc62f2af86411f5f6e74764c308bb913d636b62612c083adff28b35c39ff1ebae89dc8e7268edde8586cf5f17ddd124c47f1ee9af7eb472e863cd2786577f2b5bea15fc96f602c87aee08f64d530b4b856f02b4979a0e7368adde25885e8bea772e626547a7019c045f9e41ebf42ee1cbd1d5a20a2f3fdfea5c6e93e4d0dcc737cdfb42f535b3f880cf6b2a39a18f6da8e983d780ad13e2d6331fdd4ce7c3741de99ad576d68815acba2941e3567b692311d07d793d9c7a5b8246ad41d207097c072432af7f924471431d206df431bb7a51793d184de7d198ede37e1f17b87239c0b4781234a2cd0b1f6283fc2dc1db6b8fc982fc81c77961e9fd3ee51f3f82271d33db8767d0d0711efdabd008e0f04f1fdce2c9d0c05584cafb7daa6eff81af1f48d0c0e6c34fb4d06c99421b0f191ad67cd087420b0ddd57388c16218bb609698746bb3bb4d035d8ed3f5e41885048f3d188b5d135d0f5501197a301332eaf2bf4d16c09d0ee6d71f96d50eaefe5685340435c493f1ea97fe361418850f5c94b90d48ca0d5afbb1f1dd794a19537d98f77691a40ab5f0fe5155d23a1fa0e8382aeca29ffa85a17a342f4896a13cd8da1557bb4fb85177628d6c44d513386569ce5a50ff3a6d06aebbd5e9f9b4373c5ef4c0ad1fca95a469b44ab6d9f6a14dfe7a27400147e814bf947a5ac6e96a0154efbd06d6116ad94d5ab2537e728d4e5d990ca66d00a594dfb2568851d149bc2305a25ab3d5682aeee5ebcbe71b442a98eca2e56aa8c4f489bc23cbabafe6f95de065555a8c7bb880ca315bfb5f036a8aa1d360da633802efc583102f1e2d2dba02a662f6717f41947578c1f225e8e2e2fd434ae5941d7cbc7d5f72bd0e5c5abc5eda0cb178aa62ff28bd0a52db5d7af594297b67a01ab4097b6d411b7852ead4bcdaabb99cb027ed3437be8927917bd5279a174c90f3569796ca04b620d0c3ae12a34efa9ff4c063f96f48a8deaabbb8b278a837ec91eba64aad752b86fbcb0d1a3cc269a97f5e195e8c29e7c5bd844170e5087c3d24a7451e952b8bb5deb63d12fdc142ad7d117b43e3eb38baed3e2c5836a7441ebb329eca20bca8727595396dcec2eef9d4661df4c0da0a51fe5ed472439dc2d43dff1a5135adb68790bb0ae8896968f88db464b7fe1f1064205b4f4ff5eb58fbee1178dd154d092f6631ce8d22e5ab2a84f5795d19297730d661f2ddad217718a6849d4a14dee009ddf27d3e1eae85ceb7336a3b58cce377a070074aef5398bdd6a199d6bb682b8a68eceadcf37b80b746efd639343d0d9d1cbb61bf4978269b81a3a337f99846eb58dce14ea8600a1c57f7d4991b68e4eb7d4f41a87e5747a7eeb33376891e9c281e8f4b9a82677844e35009da2ff98140d73535571d5c6005a1679ec467aeb71c17f5c884e55c54347e8dabdd496921a142d8efdec1b31fbe8d9e241b7391c3ddb3d4d2e25b18c4edda3e515474c2d46a7fed6911bf44ea6f2c3d1b37fedb3b71e76d1a9fd6365a18b4bd0a9094ce4009d0a9736daaa8840df9b2dd507d6d16c365cdaffdb3b7f9fb681288e47728bd4d15ea0e33d09c9d92cbd0b5d919c84b50592900d293f2863d28692ad588a484722d1d2ffb6b6434bee7c71ecbb77a143362c71f627c7e5f9fdfcb2f48535a005abc723dbd0825c5a6e192d0f5a88159d77b69335abeece7397940e345bcd54e1d86e025268040f72cb68b9d0f03d10be1a5653bde70aff4e0b5a480ac6df458b950041b430c8ff876ff9d0a25bcd17166b2ea1ca91d68316b7fa035883fea2dae8b5d01bdc5ce154273dd356fc69b1973adee8fcb59ba0c55477b8b002ed89a285f1469b414b79bd86156851b430b1d186d0ac2fb6c65a8096e44e9b916b0a2d85f548dfc3e4ed632603670a2d65ab9b11758b9bdfcfb60c1b438bd926a7460ccdcec4fb9f320a68694ac2b92685869f8134d5e19240574369cc8cb2157926ddbc48e37e116859cc3818d1e56ea4b922e79a51414b7356e9b8270d74b52f65fe23970a1a0e8fa581cf88a630e04b23a06f4e191db43c90e234228a0a9d2fc9f7fef3c848a099dfab28a84d4bb4b2e4f0f31f900a3a33d296529b41676492f1b4e0da4a51af579e58726a9159a8e29f05d9d9aa626b0b43b37e457542b4a1336723759488a1b363d37834d21f0cce8e8ee327460f2dbd6f53cb770b9ad0f71966e71a5c0bd070967910763da6033dc34c6db651a233bb0c74355b70c74104a5a1593bdb79cc17cc0e341c2ada048efeeaeb1486deef29982fca34399782ce1eeb446bff2a2a53a06037a8b8c9e752c98972d04a097aacdd168506363b47e568b46b0f3afb46489f199e3c15818e8dc6570c94439936a15d4f2d28e28483bb4d6b017eb4b97271730156a1dd756a00c80723067966fbbebd46862e1883656839e05f35dacd4e7a4a546bdf3ff69d60cdb23158877673a494f8f15e677ef7f2cbcb949c3b9f5cbe09d7c935e008b600edcab1a8b86f3c1cb43ad379e24db283f9af49abcd43c41c31160d67aba03f2d5ece72c55b1c0c5fe4143708c1f30bd0f0c5b5a04dc4b6c48f77a1958dd08266708f24cc23bda8470fda44226cc53e8f61abd0b1e5eb195227025f5b8676e378c9e888e049045b87763d7613ea6f36bf3288e4f5a11383adab57eac4a6ee95a05d5d5147ac3dc0eb41034cb0343662c7334bf4984243f563b993edf0b70f60985233864ed20158e27d72340563911e0268608f7d0c8a2137bb00060fa2848683c7cbcd87c4e17b5d8fa45e43021dfb8c89f0711eb783d8987a4435480d7f7a6d7aaed50b3150800788bcd67958ee3245cb022134803f9f0c2bbcbeb482412548ed1b0f2bc36e1cce3046f6204ae8f407fff7f45b6b58afc7e721a8d7877114f3e451378790428b1983e453ac5cfdcfd0ab978cd9b9b355685b973be81df40e7a07bd83de41935ffe0137c766ad25eafc1c0000000049454e44ae426082, 1, NULL, 1, '2023-09-07 14:22:56'),
(2, 'xcjvnkd', '$2a$10$CmxpkgWZvR2E8Qo8Zrza5.Xse2zELLfOza90T6Rhp5AyvMpRRgrvW', 'nguyenminhthan1308@gmail.com', '', '', 0x89504e470d0a1a0a0000000d494844520000016800000168040300000088cb7ce60000001e504c544503537defeeeeffffff01437107395a647d8a355d739ba3a8e0dad6c1bfbef79a6e45000011834944415478daecddcd7bd3461a00f029a365d91b1e1aa0b7ce2c10e7a654928d6f491d93e4b63809901b89f9ea6d710a746f5d1158b86d155296ff76fd113b963492e67de7c3f1f3642ead795af9c778be35f30e11e3c46be3b4101fc925fa127d89be445fa22fd10b826635be58e86162b31ff88547f3cf5fdfecbdd8d80882c0dfd878b1f7eeebb778f0c717153df897dba72f48d81e78c928f9c40f828d3679f1f8532c2e209a09fec39b5e7bc24d251a0461632f31883efb273bfb73ecc7fad7dda04d4a521874dec583afd5fda2613283e6a7bdb64f2a120d1bfbff9ed6ce39a38578f32ca8248fcbc983c71722a705ffda0b88720a1aff9a3b9a89cfff681348a2e15ffe982f5af0376d9f005310eecf132d7ed80d0822059d647ee853cf27a844d79e303e1ff4db3641a7f0e558ed185dc7158d4c11718b5ee9f9442bd1c66be1187d2bd0340fbb9adf8453f48736d14f347c22dca1cd9887d5715fb8428b5343e681fa150a8d18d77e30661ee5b593498049f340fd4438402f19354fd476d1cb01319c82d7dc327aa5478ca746c2ada2ebbbbe7934ed24dc26fa570be6a19ad9438b3fd78895447fb186661fdac4520a1f5a42b3656be6813ab183aeef128b695cac4da32d55c269b1deb680664b01b19a82ae7134b3d1ab64fa98d834da72e11815904dd3aba64bd6cd8302f2841b9d04d4dbc4410a13936871e4bb40d3a63087664b6bc449f2bae6d0f51e71941acc149a9df8aed0f49521b4d53147c118441b2d8edc9927755117cd967ce252dd3581e63de234350ca0d9cd35b768ef501f5d779cd1e3664f0fcd7ef75da3e9355df40a25ce931feba11df62ba9acd65a35ad07640e2948742601ecbd3f0f34fd9b0e7a652e193dc8ea188f9e43d371de8060d1754ae694fc188b9e5b460fb2fa3b2c9af7c8dc5203896637fdf9a1e9210ecd9f9139a60738f45d7f9e68dac5a0d911996b6a62d0cbfe7cd13481a3d9173267f4161c5d0fe68c260183a2e7dade4d5b3de8aae90e997b8a387012b0ac3d9dd5ffa5bc3e10fd5eaf380ef750073408f42a464b80d05c63258c061bcf1fff6f38a5fefc666f23d0c8f13006a1357ac3f0eafeb8e2d4862fbc3f9df6f07f7fda85a019ba1ad2f0712a7b046a3bea6cafa88c5ec156c3b093e4b775d777db9ae543058d6ea48397b16c033d7f1ba09b6a7534f28572b83f1a69497e53ec5680481d8d1c2b9deda19236ae48354d54d1ec18850e7e1125cb421f51cfa4ebca68d4dc906e8bd2b52cdc2bdf48158d6a3b68a762018ea3b63f79891a9a1da3e674553be6915b02d615d13bc8ceab6aa91bf5f226525b35c5940ebaa9720e0e53acbd446912700ff1e82051d93d89da1670c055d08859387dc595f68b627adaa60aba8e281d1153dc998ba82e61ac80468c4abd2e5744df5d43547105f4174c0d57deb88dc8ea6d5e8dee21f242fde82fe2776cb04a3462b0342ed18a7ba0e1594dfb95e81bf0871e70001adea0d2ef78151a9e1321831cee45b4d551159ac3abf716ec283cbca27b71051a5e51681f768c1a5e69a693f202346284d7019efd46cce5b62bd0e0225dbc4c686e69332a47c3477883513af0943de23be2d2555378918ee087eec1bfa6d72d9d04c08bf43a1cfd3db6812a40ef20ba2b301a5e3ea232347c58dae08823a7e0e1cd70785a888617e91606fd1ede5297a06fc01b3ccca162f8f8e33e2f461fc11b3c54301070296c96a07d540d811fee05d7f78015a2e1d5ba85439fc0df1915a2c1656d54a41168cd2f4aa1dfeb65803a7a59ef27255a45cd8b7168bea6557966d1c847614203e0b247865e46752d2834b8260e870b5234bccdff191b1be40e7cf62c5f3585eff0389b0721a256c1c70b5bf249007cd6e2255834bcf9880a662ef0150f8645d7e1ab637234bc3f6ca0839ac1df457989148d986ae1d13b98fa934733f882580b8f06b779e427291afe06600b8f3ec6e490040d5fc55b77898e6468f8c87cb24700135d105e813c2641afc017a6bb2ed13491a0118fd141af21be2d8766d7114bf47834e285c315091abe6e4c350268220ae3b6040d6ff168ec14dd94a09f62871e28741df1964bb26a0a7f8aaf1320d047e4516e1280a81994bb45f773e8bb171fddcda1ef918b8e260739f4f1c5476f892cfa0481666ed1ad1c7ac72d9a23d0510e8dd8ca45633c1ad14e4f6677e7684e10e8048f46f48884c419346a8b581f8fc66c67f5fa1934ea215d3c1ab3159e66d1a887b8467733e8efc9c547939fd368c4fa41fe452a048dc9a4e12a420a7db208e85666d57447e3216e166b06a9c3d3930014dae5b2d8f98b8773346a6fb3cb05c8d1f765d06b9887385dea1da4ab710a5d47a1cfba28278beae72fd3ced13e2aa71dbebe981da1118df1cba4b547a0512dde74b043343aa8499b0747e35abc69174cb03b4067da3c041a770a6ffc865c174d190ecd7d13e81f914fe9e3d0c8c361f44a0a7d9d20ffea3834f28725d7f82c1a7b0ef83e0a8dac879377f113343686408443634fc36e1b418f768182d1c85e81904d3eb36a8a0e8b316a39c1e369f459e9d6ec24001fcbc3cd66c2f375f55934fac8b59b6d9b86d1980db2f8380b510a8d0f5ee4642bb21cfd14ff1c079bbecf6701a9d9381eed255034faf8ff747e47b0a75ba685fa1a07a2affbf81c32841ecceb81688d78f229744d034dfb30b44ea82463393d3d3aa388d689d112a65a0fa2f3a41882d68a194e53685fe7490700b45ea82473e8e90b1c1534d70a9564103d59ec5689bfad176299a6564db51e65f960f02c3a3509d043d387ca47b0fd0b83563eecce35837fa5d144f3618a61053efa26d16b9aead05e0087548fc84ca207730a05f491af8bae19450feb62155a3fa2bce19ca67ee5dd5906e26f7ba932fd54fb79b41397a3b9817bc6ae1a468fee9029417313b7d834526813c113bd57256833f78c45c6d124785588167f1a09de99469b89161bec1704a315a766028eda400fef0196c575adbf351424b599429f987928f13ab903fb42dcda3575b74a33b56afaaba1a71a0ea758301d3d431b0ccc7b1eb892e906aeac409f987bf0798850ae1b223497eea7d0bf13a369188675188c35341ba5f82c3cfc64b1e6479f2c42ba9242df5b08f4e460cd22a3ef2e06ba9b422f2f063a49a1eb8b818ed3e8b545407b2c85bebd10689a46b3de22a0a3ccb6cd9d4544ef2e027a33b3d7f46411d0adcc0ec8bf2f027a3583beb308e8f5ccd1be45e8c727dbf2a668f3fdb8f99ba4bc7e166db077198cfda7a96d701ae0251974dd54fe06e183e77b8fbf7d1acc106bb73fbfdb7bf4ac6d6cc6c5326861a44ba41bfef33fc62f2af86411f5f6e74764c308bb913d636b62612c083adff28b35c39ff1ebae89dc8e7268edde8586cf5f17ddd124c47f1ee9af7eb472e863cd2786577f2b5bea15fc96f602c87aee08f64d530b4b856f02b4979a0e7368adde25885e8bea772e626547a7019c045f9e41ebf42ee1cbd1d5a20a2f3fdfea5c6e93e4d0dcc737cdfb42f535b3f880cf6b2a39a18f6da8e983d780ad13e2d6331fdd4ce7c3741de99ad576d68815acba2941e3567b692311d07d793d9c7a5b8246ad41d207097c072432af7f924471431d206df431bb7a51793d184de7d198ede37e1f17b87239c0b4781234a2cd0b1f6283fc2dc1db6b8fc982fc81c77961e9fd3ee51f3f82271d33db8767d0d0711efdabd008e0f04f1fdce2c9d0c05584cafb7daa6eff81af1f48d0c0e6c34fb4d06c99421b0f191ad67cd087420b0ddd57388c16218bb609698746bb3bb4d035d8ed3f5e41885048f3d188b5d135d0f5501197a301332eaf2bf4d16c09d0ee6d71f96d50eaefe5685340435c493f1ea97fe361418850f5c94b90d48ca0d5afbb1f1dd794a19537d98f77691a40ab5f0fe5155d23a1fa0e8382aeca29ffa85a17a342f4896a13cd8da1557bb4fb85177628d6c44d513386569ce5a50ff3a6d06aebbd5e9f9b4373c5ef4c0ad1fca95a469b44ab6d9f6a14dfe7a27400147e814bf947a5ac6e96a0154efbd06d6116ad94d5ab2537e728d4e5d990ca66d00a594dfb2568851d149bc2305a25ab3d5682aeee5ebcbe71b442a98eca2e56aa8c4f489bc23cbabafe6f95de065555a8c7bb880ca315bfb5f036a8aa1d360da633802efc583102f1e2d2dba02a662f6717f41947578c1f225e8e2e2fd434ae5941d7cbc7d5f72bd0e5c5abc5eda0cb178aa62ff28bd0a52db5d7af594297b67a01ab4097b6d411b7852ead4bcdaabb99cb027ed3437be8927917bd5279a174c90f3569796ca04b620d0c3ae12a34efa9ff4c063f96f48a8deaabbb8b278a837ec91eba64aad752b86fbcb0d1a3cc269a97f5e195e8c29e7c5bd844170e5087c3d24a7451e952b8bb5deb63d12fdc142ad7d117b43e3eb38baed3e2c5836a7441ebb329eca20bca8727595396dcec2eef9d4661df4c0da0a51fe5ed472439dc2d43dff1a5135adb68790bb0ae8896968f88db464b7fe1f1064205b4f4ff5eb58fbee1178dd154d092f6631ce8d22e5ab2a84f5795d19297730d661f2ddad217718a6849d4a14dee009ddf27d3e1eae85ceb7336a3b58cce377a070074aef5398bdd6a199d6bb682b8a68eceadcf37b80b746efd639343d0d9d1cbb61bf4978269b81a3a337f99846eb58dce14ea8600a1c57f7d4991b68e4eb7d4f41a87e5747a7eeb33376891e9c281e8f4b9a82677844e35009da2ff98140d73535571d5c6005a1679ec467aeb71c17f5c884e55c54347e8dabdd496921a142d8efdec1b31fbe8d9e241b7391c3ddb3d4d2e25b18c4edda3e515474c2d46a7fed6911bf44ea6f2c3d1b37fedb3b71e76d1a9fd6365a18b4bd0a9094ce4009d0a9736daaa8840df9b2dd507d6d16c365cdaffdb3b7f9fb681288e47728bd4d15ea0e33d09c9d92cbd0b5d919c84b50592900d293f2863d28692ad588a484722d1d2ffb6b6434bee7c71ecbb77a143362c71f627c7e5f9fdfcb2f48535a005abc723dbd0825c5a6e192d0f5a88159d77b69335abeece7397940e345bcd54e1d86e025268040f72cb68b9d0f03d10be1a5653bde70aff4e0b5a480ac6df458b950041b430c8ff876ff9d0a25bcd17166b2ea1ca91d68316b7fa035883fea2dae8b5d01bdc5ce154273dd356fc69b1973adee8fcb59ba0c55477b8b002ed89a285f1469b414b79bd86156851b430b1d186d0ac2fb6c65a8096e44e9b916b0a2d85f548dfc3e4ed632603670a2d65ab9b11758b9bdfcfb60c1b438bd926a7460ccdcec4fb9f320a68694ac2b92685869f8134d5e19240574369cc8cb2157926ddbc48e37e116859cc3818d1e56ea4b922e79a51414b7356e9b8270d74b52f65fe23970a1a0e8fa581cf88a630e04b23a06f4e191db43c90e234228a0a9d2fc9f7fef3c848a099dfab28a84d4bb4b2e4f0f31f900a3a33d296529b41676492f1b4e0da4a51af579e58726a9159a8e29f05d9d9aa626b0b43b37e457542b4a1336723759488a1b363d37834d21f0cce8e8ee327460f2dbd6f53cb770b9ad0f71966e71a5c0bd070967910763da6033dc34c6db651a233bb0c74355b70c74104a5a1593bdb79cc17cc0e341c2ada048efeeaeb1486deef29982fca34399782ce1eeb446bff2a2a53a06037a8b8c9e752c98972d04a097aacdd168506363b47e568b46b0f3afb46489f199e3c15818e8dc6570c94439936a15d4f2d28e28483bb4d6b017eb4b97271730156a1dd756a00c80723067966fbbebd46862e1883656839e05f35dacd4e7a4a546bdf3ff69d60cdb23158877673a494f8f15e677ef7f2cbcb949c3b9f5cbe09d7c935e008b600edcab1a8b86f3c1cb43ad379e24db283f9af49abcd43c41c31160d67aba03f2d5ece72c55b1c0c5fe4143708c1f30bd0f0c5b5a04dc4b6c48f77a1958dd08266708f24cc23bda8470fda44226cc53e8f61abd0b1e5eb195227025f5b8676e378c9e888e049045b87763d7613ea6f36bf3288e4f5a11383adab57eac4a6ee95a05d5d5147ac3dc0eb41034cb0343662c7334bf4984243f563b993edf0b70f60985233864ed20158e27d72340563911e0268608f7d0c8a2137bb00060fa2848683c7cbcd87c4e17b5d8fa45e43021dfb8c89f0711eb783d8987a4435480d7f7a6d7aaed50b3150800788bcd67958ee3245cb022134803f9f0c2bbcbeb482412548ed1b0f2bc36e1cce3046f6204ae8f407fff7f45b6b58afc7e721a8d7877114f3e451378790428b1983e453ac5cfdcfd0ab978cd9b9b355685b973be81df40e7a07bd83de41935ffe0137c766ad25eafc1c0000000049454e44ae426082, 0, 'JMUAVgSf', 2, '2023-09-09 10:31:15');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoices`
--

CREATE TABLE `invoices` (
  `invoice_id` varchar(255) NOT NULL,
  `delivery_date` datetime DEFAULT NULL,
  `delivery_location` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `payment_method` enum('cash','bank','credit_card') NOT NULL,
  `is_cancelled` tinyint(1) DEFAULT NULL,
  `is_import` tinyint(1) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `deleted_at` datetime DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `return_id` int(11) DEFAULT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice_detail`
--

CREATE TABLE `invoice_detail` (
  `id` int(11) NOT NULL,
  `product_code` varchar(255) NOT NULL,
  `invoice_id` varchar(255) NOT NULL,
  `product_price` double NOT NULL,
  `product_quantity` double NOT NULL,
  `is_discount` tinyint(1) DEFAULT NULL,
  `discount_amount` double DEFAULT NULL,
  `is_returned` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `leave_infor`
--

CREATE TABLE `leave_infor` (
  `leave_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `leave_type` varchar(255) NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `reason` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `positions`
--

CREATE TABLE `positions` (
  `position_id` int(11) NOT NULL,
  `position_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `positions`
--

INSERT INTO `positions` (`position_id`, `position_name`) VALUES
(1, 'admin'),
(2, 'warehouse manager'),
(3, 'sales manager'),
(4, 'sales staff');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `product_code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `quantity` double NOT NULL,
  `image` longblob NOT NULL,
  `discount_percent` int(11) DEFAULT NULL,
  `disable` tinyint(1) NOT NULL,
  `created_at` datetime NOT NULL,
  `unit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product_category`
--

CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL,
  `product_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reports`
--

CREATE TABLE `reports` (
  `report_id` int(11) NOT NULL,
  `employees_id` int(11) NOT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL,
  `description` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `return_product`
--

CREATE TABLE `return_product` (
  `id` int(11) NOT NULL,
  `invoice_detail_id` int(11) NOT NULL,
  `quantity_returned` double NOT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `returned_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `suppliers`
--

CREATE TABLE `suppliers` (
  `supplier_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `units`
--

CREATE TABLE `units` (
  `unit_id` int(11) NOT NULL,
  `unit_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Chỉ mục cho bảng `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`),
  ADD UNIQUE KEY `customer_email` (`email`);

--
-- Chỉ mục cho bảng `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_id`),
  ADD UNIQUE KEY `employee_email` (`email`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `position_id` (`position_id`);

--
-- Chỉ mục cho bảng `invoices`
--
ALTER TABLE `invoices`
  ADD PRIMARY KEY (`invoice_id`),
  ADD KEY `supplier_id` (`supplier_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `employee_id` (`employee_id`),
  ADD KEY `return_id` (`return_id`);

--
-- Chỉ mục cho bảng `invoice_detail`
--
ALTER TABLE `invoice_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_code` (`product_code`),
  ADD KEY `invoice_id` (`invoice_id`);

--
-- Chỉ mục cho bảng `leave_infor`
--
ALTER TABLE `leave_infor`
  ADD PRIMARY KEY (`leave_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Chỉ mục cho bảng `positions`
--
ALTER TABLE `positions`
  ADD PRIMARY KEY (`position_id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_code`),
  ADD KEY `unit_id` (`unit_id`);

--
-- Chỉ mục cho bảng `product_category`
--
ALTER TABLE `product_category`
  ADD KEY `category_id` (`category_id`,`product_code`),
  ADD KEY `product_code` (`product_code`);

--
-- Chỉ mục cho bảng `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`report_id`),
  ADD KEY `employees_id` (`employees_id`),
  ADD KEY `manager_id` (`manager_id`);

--
-- Chỉ mục cho bảng `return_product`
--
ALTER TABLE `return_product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `invoice_detail_id` (`invoice_detail_id`);

--
-- Chỉ mục cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`supplier_id`);

--
-- Chỉ mục cho bảng `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`unit_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `invoice_detail`
--
ALTER TABLE `invoice_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `leave_infor`
--
ALTER TABLE `leave_infor`
  MODIFY `leave_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `positions`
--
ALTER TABLE `positions`
  MODIFY `position_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `reports`
--
ALTER TABLE `reports`
  MODIFY `report_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `return_product`
--
ALTER TABLE `return_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `supplier_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `units`
--
ALTER TABLE `units`
  MODIFY `unit_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`position_id`) REFERENCES `positions` (`position_id`);

--
-- Các ràng buộc cho bảng `invoices`
--
ALTER TABLE `invoices`
  ADD CONSTRAINT `invoice_return` FOREIGN KEY (`return_id`) REFERENCES `return_product` (`id`),
  ADD CONSTRAINT `invoices_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`),
  ADD CONSTRAINT `invoices_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`),
  ADD CONSTRAINT `invoices_ibfk_3` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`);

--
-- Các ràng buộc cho bảng `invoice_detail`
--
ALTER TABLE `invoice_detail`
  ADD CONSTRAINT `invoice_detail_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `products` (`product_code`),
  ADD CONSTRAINT `invoice_detail_ibfk_2` FOREIGN KEY (`invoice_id`) REFERENCES `invoices` (`invoice_id`);

--
-- Các ràng buộc cho bảng `leave_infor`
--
ALTER TABLE `leave_infor`
  ADD CONSTRAINT `leave_infor_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`employee_id`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`unit_id`) REFERENCES `units` (`unit_id`);

--
-- Các ràng buộc cho bảng `product_category`
--
ALTER TABLE `product_category`
  ADD CONSTRAINT `product_category_ibfk_1` FOREIGN KEY (`product_code`) REFERENCES `products` (`product_code`),
  ADD CONSTRAINT `product_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`);

--
-- Các ràng buộc cho bảng `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `Report_Employee` FOREIGN KEY (`employees_id`) REFERENCES `employees` (`employee_id`),
  ADD CONSTRAINT `Report_Manager` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`employee_id`);

--
-- Các ràng buộc cho bảng `return_product`
--
ALTER TABLE `return_product`
  ADD CONSTRAINT `return_product_ibfk_1` FOREIGN KEY (`invoice_detail_id`) REFERENCES `invoice_detail` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
