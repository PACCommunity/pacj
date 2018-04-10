package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {


    public static final String coinName = "$PAC";
    public static final String coinTicker = "$PAC";
    public static final String coinURIScheme = "paccoin";
    public static final String cryptsyMarketId = "155";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[X]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;

    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/dash/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;

    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://usa.pacblockexplorer.com:3002/";    //blockr.io
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "address/";             //blockr.io path
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "tx/";              //blockr.io path
    public static final String BLOCKEXPLORER_BLOCK_PATH = "block/";                 //blockr.io path
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://test.explorer.dash.org/";

    public static final String DONATION_ADDRESS = "PEu6JJcBPohthZAUQJw81mMws8KJyqcDoQ";  //donation $PAC address

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(24 * 60 * 60);  // 24 hours per difficulty cycle, on average.
    public static final int TARGET_SPACING = (int)(2.5 * 60);  // 2.5 minutes seconds per block.
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  //57 blocks

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;      //108
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;    //72 min
    }

    public static int spendableCoinbaseDepth = 100; //main.h: static const int COINBASE_MATURITY
    public static final long MAX_COINS = 22000000;                 //main.h:  MAX_MONEY


    public static final long DEFAULT_MIN_TX_FEE = 10000;   // MIN_TX_FEE
    public static final long DUST_LIMIT = 5460; //Transaction.h CTransaction::GetDustThreshold for 10000 MIN_TX_FEE
    public static final long INSTANTX_FEE = 100000; //0.001 $PAC (updated for 12.1)
    public static final boolean feeCanBeRaised = false;

    public static final int PROTOCOL_VERSION = 70212;          //version.h PROTOCOL_VERSION
    public static final int MIN_PROTOCOL_VERSION = 70212;        //version.h MIN_PROTO_VERSION

    public static final int BLOCK_CURRENTVERSION = 2;   //CBlock::CURRENT_VERSION
    public static final int MAX_BLOCK_SIZE = 1 * 1000 * 1000;


    public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

    public static final int Port    = 7112;       //protocol.h GetDefaultPort(testnet=false)
    public static final int TestPort = 17112;     //protocol.h GetDefaultPort(testnet=true)
 
    //
    //  Production
    //
    public static final int AddressHeader = 55;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS
    public static final int p2shHeader = 10;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS
    public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
    public static final long oldPacketMagic = 0xfbc0b6db;      //0xfb, 0xc0, 0xb6, 0xdb
    public static final long PacketMagic = 0xc8e5612c;

    //Genesis Block Information from main.cpp: LoadBlockIndex
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long genesisBlockTime = 1517541873L;                       //main.cpp: LoadBlockIndex
    static public long genesisBlockNonce = (340503L);                         //main.cpp: LoadBlockIndex
    static public String genesisHash = "00000354655ff039a51273fe61d3b493bd2897fe6c16f732dbc4ae19f04b789e"; //main.cpp: hashGenesisBlock
    static public String genesisMerkleRoot = "f3939e4de05e537431ef32bbebd9bc7c4e701f7205d72016f04686557af58dbf";
    static public int genesisBlockValue = 50;                                                              //main.cpp: LoadBlockIndex
    //taken from the raw data of the block explorer
    // static public String genesisTxInBytes = "04ffff001d01044c5957697265642030392f4a616e2f3230313420546865204772616e64204578706572696d656e7420476f6573204c6976653a204f76657273746f636b2e636f6d204973204e6f7720416363657074696e6720426974636f696e73";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    // static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    static public String genesisTxInBytes = "04ffff001d01044c57426974636f696e20426c6f636b20233530373230323a2030303030303030303030303030303030303032646366383861643766656365383639346361663735313234626131383165323963653338633736623763333738";   //"limecoin se convertira en una de las monedas mas segura del mercado, checa nuestros avances"
    static public String genesisTxOutBytes = "0411345e927d2d3abb85541e23b211f5b9019f2b240fb9bd4b1c44234993639293846cfc74154d293a3bf7ba74592f5f358127c0062a621d3b153089d0f5bb84e5";


    //net.cpp strDNSSeed
    static public String[] dnsSeeds = new String[] {
            "dnsseed1.paccoin.io",
            "dnsseed2.paccoin.io"
    };


    public static int minBroadcastConnections = 0;   //0 for default; Using 3 like BreadWallet.

    //
    // TestNet - $PAC
    //
    public static final boolean supportsTestNet = true;
    public static final int testnetAddressHeader = 140;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
    public static final int testnetp2shHeader = 19;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
    public static final long testnetPacketMagic = 0xcee2caff;      //
    public static final String testnetGenesisHash = "00000da63bd9478b655ef6bf1bf76cd9af05202ab68643f9091e049b2b5280ed";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockTime = 1517541975L;                       //main.cpp: LoadBlockIndex
    static public long testnetGenesisBlockNonce = (2279587L);                         //main.cpp: LoadBlockIndex





    //main.cpp GetBlockValue(height, fee)
    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(100, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(420000, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210240;     //main.cpp GetBlockValue(height, fee)

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // digitalcoin: starting difficulty is 1 / 2^12

    static public String[] testnetDnsSeeds = new String[] {
            "testnet-seed.paccoindot.io",
            "test.dnsseed.masternode.io",
    };
    //from main.h: CAlert::CheckSignature
    public static final String SATOSHI_KEY = "048240a8748a80a286b270ba126705ced4f2ce5a7847b3610ea3c06513150dade2a8512ed5ea86320824683fc0818f0ac019214973e677acd1244f6d0571fc5103";
    public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.darkcoin.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.darkcoin.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.darkcoin.unittest";

    //checkpoints.cpp Checkpoints::mapCheckpoints
    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {

        checkpoints.put(  100, Sha256Hash.wrap("000005065df82218140bc7c59cfd6913eaa5a88f3255ccc977c546cb0beb9ff0"));
        checkpoints.put(  12096, Sha256Hash.wrap("0000000000000097702bbbfb8c00bb228dd1e2f95ae448fc504b35a46bfcd4fe"));
        checkpoints.put(  15000, Sha256Hash.wrap("00000000000001d2b0bbeaabd957dc7a80ea6f8ecc39ec32f60c70391288893b"));
        checkpoints.put( 20000, Sha256Hash.wrap("000000000000006abf889a12aa85fe3c713f2520e0af1c1adf2ef70df0fb3320"));
        checkpoints.put( 21822, Sha256Hash.wrap("000000000000002d00501b6de7a9bd92c8cb2e4874a17bc3c817825539203555"));
        checkpoints.put( 24005, Sha256Hash.wrap("000000000000030cc60b574b820f0651bd5850d8cfc438d8ed10d184d6de53ff"));
        checkpoints.put( 29239, Sha256Hash.wrap("00000000000001c7cfaf4d57fb28e134a0aaf26ef994c6d8fc499c0141ed6ab2"));
    }

    //Unit Test Information
    public static final String UNITTEST_ADDRESS = "XgxQxd6B8iYgEEryemnJrpvoWZ3149MCkK";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "XDtvHyDHk4S3WJvwjxSANCpZiLLkKzoDnjrcRhca2iLQRtGEz1JZ";

}
