/*
 * Copyright 2013 Google Inc.
 * Copyright 2015 Andreas Schildbach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bitcoinj.params;

import org.bitcoinj.core.*;

import static com.google.common.base.Preconditions.*;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends AbstractBitcoinNetParams {
    public static final int MAINNET_MAJORITY_WINDOW = 1000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 950;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 750;

    public static final int MAINNET_MAJORITY_DIP0001_WINDOW = 4032;
    public static final int MAINNET_MAJORITY_DIP0001_THRESHOLD = 3226;

    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = CoinDefinition.proofOfWorkLimit;
        dumpedPrivateKeyHeader = 204;
        addressHeader = CoinDefinition.AddressHeader;
        p2shHeader = CoinDefinition.p2shHeader;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader};
        port = CoinDefinition.Port;
        packetMagic = CoinDefinition.PacketMagic;
        bip32HeaderPub = 0x0488B21E; //The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderPriv = 0x0488ADE4; //The 4 byte header that serializes in base58 to "xprv"
        genesisBlock.setDifficultyTarget(CoinDefinition.genesisBlockDifficultyTarget);
        genesisBlock.setTime(CoinDefinition.genesisBlockTime);
        genesisBlock.setNonce(CoinDefinition.genesisBlockNonce);

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        id = ID_MAINNET;
        subsidyDecreaseBlockCount = CoinDefinition.subsidyDecreaseBlockCount;
        spendableCoinbaseDepth = CoinDefinition.spendableCoinbaseDepth;
        String genesisHash = genesisBlock.getHashAsString();
        // checkState(genesisHash.equals(CoinDefinition.genesisHash),
        //         genesisHash);

        //CoinDefinition.initCheckpoints(checkpoints);

        dnsSeeds = CoinDefinition.dnsSeeds;

        httpSeeds = null; /*new HttpDiscovery.Details[] {*/

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(  1500, Sha256Hash.wrap("000000aaf0300f59f49bc3e970bad15c11f961fe2347accffff19d96ec9778e3"));
        checkpoints.put(  4991, Sha256Hash.wrap("000000003b01809551952460744d5dbb8fcbd6cbae3c220267bf7fa43f837367"));
        checkpoints.put(  9918, Sha256Hash.wrap("00000000213e229f332c0ffbe34defdaa9e74de87f2d8d1f01af8d121c3c170b"));
        checkpoints.put( 16912, Sha256Hash.wrap("00000000075c0d10371d55a60634da70f197548dbbfa4123e12abfcbc5738af9"));
        checkpoints.put( 23912, Sha256Hash.wrap("0000000000335eac6703f3b1732ec8b2f89c3ba3a7889e5767b090556bb9a276"));
        checkpoints.put( 35457, Sha256Hash.wrap("0000000000b0ae211be59b048df14820475ad0dd53b9ff83b010f71a77342d9f"));
        checkpoints.put( 45479, Sha256Hash.wrap("000000000063d411655d590590e16960f15ceea4257122ac430c6fbe39fbf02d"));
        checkpoints.put( 55895, Sha256Hash.wrap("0000000000ae4c53a43639a4ca027282f69da9c67ba951768a20415b6439a2d7"));
        checkpoints.put( 68899, Sha256Hash.wrap("0000000000194ab4d3d9eeb1f2f792f21bb39ff767cb547fe977640f969d77b7"));
        checkpoints.put( 74619, Sha256Hash.wrap("000000000011d28f38f05d01650a502cc3f4d0e793fbc26e2a2ca71f07dc3842"));
        checkpoints.put( 75095, Sha256Hash.wrap("0000000000193d12f6ad352a9996ee58ef8bdc4946818a5fec5ce99c11b87f0d"));
        checkpoints.put( 88805, Sha256Hash.wrap("00000000001392f1652e9bf45cd8bc79dc60fe935277cd11538565b4a94fa85f"));
        checkpoints.put( 107996, Sha256Hash.wrap("00000000000a23840ac16115407488267aa3da2b9bc843e301185b7d17e4dc40"));
        checkpoints.put( 137993, Sha256Hash.wrap("00000000000cf69ce152b1bffdeddc59188d7a80879210d6e5c9503011929c3c"));
        checkpoints.put( 167996, Sha256Hash.wrap("000000000009486020a80f7f2cc065342b0c2fb59af5e090cd813dba68ab0fed"));
        checkpoints.put( 207992, Sha256Hash.wrap("00000000000d85c22be098f74576ef00b7aa00c05777e966aff68a270f1e01a5"));
        checkpoints.put( 312645, Sha256Hash.wrap("0000000000059dcb71ad35a9e40526c44e7aae6c99169a9e7017b7d84b1c2daf"));
        checkpoints.put( 407452, Sha256Hash.wrap("000000000003c6a87e73623b9d70af7cd908ae22fee466063e4ffc20be1d2dbc"));
        checkpoints.put( 523412, Sha256Hash.wrap("000000000000e54f036576a10597e0e42cc22a5159ce572f999c33975e121d4d"));
        checkpoints.put( 523930, Sha256Hash.wrap("0000000000000bccdb11c2b1cfb0ecab452abf267d89b7f46eaf2d54ce6e652c"));
/*

        dnsSeeds = new String[] {
                "seed.bitcoin.sipa.be",         // Pieter Wuille
                "dnsseed.bluematt.me",          // Matt Corallo
                "dnsseed.bitcoin.dashjr.org",   // Luke Dashjr
                "seed.bitcoinstats.com",        // Chris Decker
                "seed.bitnodes.io",             // Addy Yeow
                "bitseed.xf2.org",              // Jeff Garzik
                "seed.bitcoin.jonasschnelli.ch" // Jonas Schnelli
        };
        httpSeeds = new HttpDiscovery.Details[] {
                // Andreas Schildbach
                new HttpDiscovery.Details(
                        ECKey.fromPublicOnly(Utils.HEX.decode("0238746c59d46d5408bf8b1d0af5740fe1a6e1703fcb56b2953f0b965c740d256f")),
                        URI.create("http://httpseed.bitcoin.schildbach.de/peers")
                )
        };                  */

        addrSeeds = null; /*new int[] {
                0x1ddb1032, 0x6242ce40, 0x52d6a445, 0x2dd7a445, 0x8a53cd47, 0x73263750, 0xda23c257, 0xecd4ed57,
                0x0a40ec59, 0x75dce160, 0x7df76791, 0x89370bad, 0xa4f214ad, 0x767700ae, 0x638b0418, 0x868a1018,
                0xcd9f332e, 0x0129653e, 0xcc92dc3e, 0x96671640, 0x56487e40, 0x5b66f440, 0xb1d01f41, 0xf1dc6041,
                0xc1d12b42, 0x86ba1243, 0x6be4df43, 0x6d4cef43, 0xd18e0644, 0x1ab0b344, 0x6584a345, 0xe7c1a445,
                0x58cea445, 0xc5daa445, 0x21dda445, 0x3d3b5346, 0x13e55347, 0x1080d24a, 0x8e611e4b, 0x81518e4b,
                0x6c839e4b, 0xe2ad0a4c, 0xfbbc0a4c, 0x7f5b6e4c, 0x7244224e, 0x1300554e, 0x20690652, 0x5a48b652,
                0x75c5c752, 0x4335cc54, 0x340fd154, 0x87c07455, 0x087b2b56, 0x8a133a57, 0xac23c257, 0x70374959,
                0xfb63d45b, 0xb9a1685c, 0x180d765c, 0x674f645d, 0x04d3495e, 0x1de44b5e, 0x4ee8a362, 0x0ded1b63,
                0xc1b04b6d, 0x8d921581, 0x97b7ea82, 0x1cf83a8e, 0x91490bad, 0x09dc75ae, 0x9a6d79ae, 0xa26d79ae,
                0x0fd08fae, 0x0f3e3fb2, 0x4f944fb2, 0xcca448b8, 0x3ecd6ab8, 0xa9d5a5bc, 0x8d0119c1, 0x045997d5,
                0xca019dd9, 0x0d526c4d, 0xabf1ba44, 0x66b1ab55, 0x1165f462, 0x3ed7cbad, 0xa38fae6e, 0x3bd2cbad,
                0xd36f0547, 0x20df7840, 0x7a337742, 0x549f8e4b, 0x9062365c, 0xd399f562, 0x2b5274a1, 0x8edfa153,
                0x3bffb347, 0x7074bf58, 0xb74fcbad, 0x5b5a795b, 0x02fa29ce, 0x5a6738d4, 0xe8a1d23e, 0xef98c445,
                0x4b0f494c, 0xa2bc1e56, 0x7694ad63, 0xa4a800c3, 0x05fda6cd, 0x9f22175e, 0x364a795b, 0x536285d5,
                0xac44c9d4, 0x0b06254d, 0x150c2fd4, 0x32a50dcc, 0xfd79ce48, 0xf15cfa53, 0x66c01e60, 0x6bc26661,
                0xc03b47ae, 0x4dda1b81, 0x3285a4c1, 0x883ca96d, 0x35d60a4c, 0xdae09744, 0x2e314d61, 0x84e247cf,
                0x6c814552, 0x3a1cc658, 0x98d8f382, 0xe584cb5b, 0x15e86057, 0x7b01504e, 0xd852dd48, 0x56382f56,
                0x0a5df454, 0xa0d18d18, 0x2e89b148, 0xa79c114c, 0xcbdcd054, 0x5523bc43, 0xa9832640, 0x8a066144,
                0x3894c3bc, 0xab76bf58, 0x6a018ac1, 0xfebf4f43, 0x2f26c658, 0x31102f4e, 0x85e929d5, 0x2a1c175e,
                0xfc6c2cd1, 0x27b04b6d, 0xdf024650, 0x161748b8, 0x28be6580, 0x57be6580, 0x1cee677a, 0xaa6bb742,
                0x9a53964b, 0x0a5a2d4d, 0x2434c658, 0x9a494f57, 0x1ebb0e48, 0xf610b85d, 0x077ecf44, 0x085128bc,
                0x5ba17a18, 0x27ca1b42, 0xf8a00b56, 0xfcd4c257, 0xcf2fc15e, 0xd897e052, 0x4cada04f, 0x2f35f6d5,
                0x382ce8c9, 0xe523984b, 0x3f946846, 0x60c8be43, 0x41da6257, 0xde0be142, 0xae8a544b, 0xeff0c254,
                0x1e0f795b, 0xaeb28890, 0xca16acd9, 0x1e47ddd8, 0x8c8c4829, 0xd27dc747, 0xd53b1663, 0x4096b163,
                0x9c8dd958, 0xcb12f860, 0x9e79305c, 0x40c1a445, 0x4a90c2bc, 0x2c3a464d, 0x2727f23c, 0x30b04b6d,
                0x59024cb8, 0xa091e6ad, 0x31b04b6d, 0xc29d46a6, 0x63934fb2, 0xd9224dbe, 0x9f5910d8, 0x7f530a6b,
                0x752e9c95, 0x65453548, 0xa484be46, 0xce5a1b59, 0x710e0718, 0x46a13d18, 0xdaaf5318, 0xc4a8ff53,
                0x87abaa52, 0xb764cf51, 0xb2025d4a, 0x6d351e41, 0xc035c33e, 0xa432c162, 0x61ef34ae, 0xd16fddbc,
                0x0870e8c1, 0x3070e8c1, 0x9c71e8c1, 0xa4992363, 0x85a1f663, 0x4184e559, 0x18d96ed8, 0x17b8dbd5,
                0x60e7cd18, 0xe5ee104c, 0xab17ac62, 0x1e786e1b, 0x5d23b762, 0xf2388fae, 0x88270360, 0x9e5b3d80,
                0x7da518b2, 0xb5613b45, 0x1ad41f3e, 0xd550854a, 0x8617e9a9, 0x925b229c, 0xf2e92542, 0x47af0544,
                0x73b5a843, 0xb9b7a0ad, 0x03a748d0, 0x0a6ff862, 0x6694df62, 0x3bfac948, 0x8e098f4f, 0x746916c3,
                0x02f38e4f, 0x40bb1243, 0x6a54d162, 0x6008414b, 0xa513794c, 0x514aa343, 0x63781747, 0xdbb6795b,
                0xed065058, 0x42d24b46, 0x1518794c, 0x9b271681, 0x73e4ffad, 0x0654784f, 0x438dc945, 0x641846a6,
                0x2d1b0944, 0x94b59148, 0x8d369558, 0xa5a97662, 0x8b705b42, 0xce9204ae, 0x8d584450, 0x2df61555,
                0xeebff943, 0x2e75fb4d, 0x3ef8fc57, 0x9921135e, 0x8e31042e, 0xb5afad43, 0x89ecedd1, 0x9cfcc047,
                0x8fcd0f4c, 0xbe49f5ad, 0x146a8d45, 0x98669ab8, 0x98d9175e, 0xd1a8e46d, 0x839a3ab8, 0x40a0016c,
                0x6d27c257, 0x977fffad, 0x7baa5d5d, 0x1213be43, 0xb167e5a9, 0x640fe8ca, 0xbc9ea655, 0x0f820a4c,
                0x0f097059, 0x69ac957c, 0x366d8453, 0xb1ba2844, 0x8857f081, 0x70b5be63, 0xc545454b, 0xaf36ded1,
                0xb5a4b052, 0x21f062d1, 0x72ab89b2, 0x74a45318, 0x8312e6bc, 0xb916965f, 0x8aa7c858, 0xfe7effad,
        };                  */

        strSporkKey = "04549ac134f694c0243f503e8c8a9a986f5de6610049c40b07816809b0d1d06a21b07be27b9bb555931773f62ba6cf35a25fd52f694d4e1106ccd237a7bb899fdd";
        budgetPaymentsStartBlock = 328008;

        DIP0001Window = MAINNET_MAJORITY_DIP0001_WINDOW;
        DIP0001Upgrade = MAINNET_MAJORITY_DIP0001_THRESHOLD;
        DIP0001BlockHeight = 782208;
    }

    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
