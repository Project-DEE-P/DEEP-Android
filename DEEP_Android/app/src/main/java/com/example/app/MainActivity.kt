package com.example.app

import android.app.PendingIntent
import android.content.Intent
import android.nfc.NdefMessage
import android.nfc.NdefRecord
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.Ndef
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.navigation.BottomNavigation
import com.example.app.presentation.navigation.NavGraph
import com.example.app.ui.theme.DEEP_AndroidTheme
import com.example.app.util.TAG
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel : MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DEEP_AndroidTheme {
                MainScreenView(viewModel, this)
            }
        }

        viewModel.nfcAdapter = NfcAdapter.getDefaultAdapter(this)
    }

    fun createNdefMessage(url: String): NdefMessage {
        val record = NdefRecord.createUri(url)
        return NdefMessage(arrayOf(record))
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        Log.d(TAG, "onNewIntent: ${intent}")

        if (NfcAdapter.ACTION_NDEF_DISCOVERED == intent.action || NfcAdapter.ACTION_TAG_DISCOVERED == intent.action) {
//            val ndefMessage = createNdefMessage("https://www.github.com/PARAOOO") // 원하는 URL로 변경
//            writeNdefMessageToTag(intent, ndefMessage)
            viewModel.intent = intent
            Log.d(TAG, "onNewIntent: 연결되었스빈당")
            viewModel.updateIsConnected(true)
        }
        else{
            viewModel.intent = null
            Log.d(TAG, "onNewIntent: 연결해제되었습니당")
            viewModel.updateIsConnected(false)
        }
    }

    fun writeNdefMessageToTag(intent: Intent, ndefMessage: NdefMessage) {
        Log.d(TAG, "writeNdefMessageToTag 호출됨")
        val tag = intent.getParcelableExtra<Tag>(NfcAdapter.EXTRA_TAG)
        val ndef = Ndef.get(tag)

        try {
            ndef.connect()
            ndef.writeNdefMessage(ndefMessage)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.d(TAG, "writeNdefMessageToTag: ${ e.printStackTrace() }")
            viewModel.isFail = true
        } finally {
            viewModel.isSuccessed = !viewModel.isFail
            viewModel.isFail = false
            viewModel.updateIsConnected(false)
            lifecycleScope.launchWhenStarted {
                viewModel.successEvent.emit(viewModel.isSuccessed!!)
            }
            try {
                ndef.close()
                Log.d(TAG, "writeNdefMessageToTag: NDEF가 종료되었ㅅ브니다")

            } catch (e: IOException) {
                e.printStackTrace()
                Log.d(TAG, "writeNdefMessageToTag: ${ e.printStackTrace() }")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
        val intent = Intent(this, javaClass).apply {
            addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING)
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)
        viewModel.nfcAdapter?.enableForegroundDispatch(this, pendingIntent, null, null)
    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        super.onPause()
        viewModel.nfcAdapter?.disableForegroundDispatch(this)
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView(
    mainViewModel: MainViewModel,
    activity: MainActivity
){
    val navController = rememberNavController()
    var alert: (@Composable () -> Unit) by remember { mutableStateOf({}) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val onBottomNav = when (navBackStackEntry?.destination?.route) {
        "put_nfc_screen" -> true
        "card_list_screen" -> true
        "profile_screen" -> true
        else -> false
    }

    Box {
        Scaffold(
            bottomBar = {
                if (onBottomNav) {
                    BottomNavigation(navController = navController)
                }
            }
        ) {
            Box(
                modifier = Modifier
                    .padding(it)
            ){
                NavGraph(
                    navController = navController,
                    mainViewModel = mainViewModel,
                    activity = activity,
                    alert = { alert = it }
                )
            }
        }
        alert()
    }
    

}
