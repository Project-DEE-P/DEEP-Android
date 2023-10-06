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
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app.presentation.navigation.BottomNavItem
import com.example.app.presentation.navigation.NavGraph
import com.example.app.presentation.navigation.Screen
import com.example.app.presentation.screen.login.LoginViewModel
import com.example.app.presentation.screen.start.StartScreen
import com.example.app.presentation.screen.start.StartViewModel
import com.example.app.ui.theme.Blue100
import com.example.app.ui.theme.DEEP_AndroidTheme
import com.example.app.ui.theme.DeepBlue
import com.example.app.util.TAG
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel : MainViewModel by viewModels()
    val startViewModel : StartViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DEEP_AndroidTheme {
                MainScreenView(viewModel, startViewModel)
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
fun MainScreenView(mainViewModel: MainViewModel, startViewModel: StartViewModel){
    val navController = rememberNavController()
    var alert: (@Composable () -> Unit) by remember { mutableStateOf({}) }

    Box {
        Scaffold(
            bottomBar = { BottomNavigation(navController = navController)}
        ) {
            Box(
                modifier = Modifier
                    .padding(it)
            ){
                NavGraph(
                    navController = navController,
                    mainViewModel = mainViewModel,
                    startViewModel = startViewModel,
                    alert = { alert = it }
                )
            }
        }
        alert()
    }
    

}

@Composable
fun BottomNavigation(navController: NavController){

    val items = listOf<BottomNavItem>(
        BottomNavItem.PutNfc,
        BottomNavItem.CardList,
        BottomNavItem.Profile
    )

    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        contentColor = DeepBlue
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                },
                label = {
                    if(selected) Text( item.title, fontSize = 9.sp, color = DeepBlue)
                    else Text( item.title, fontSize = 9.sp, color = Blue100)
                     },
                selectedContentColor = DeepBlue,
                unselectedContentColor = Blue100,
                selected = selected,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

    }

}

