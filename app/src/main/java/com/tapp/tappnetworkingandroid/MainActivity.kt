package com.tapp.tappnetworkingandroid
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.tapp.tappnetworking.core.networking.Endpoints
import com.tapp.tappnetworkingandroid.TestConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tv = TextView(this).apply {
            textSize = 14f
            setPadding(24, 48, 24, 48)
        }
        setContentView(tv)

        // Build endpoint
        val ep = Endpoints.secrets(TestConfig)

        // Convert to a transport-ready request (includes final URL, headers, body bytes)
        val req = ep.toHttpRequest(TestConfig.env)

        val bodyPreview = req.body?.let { String(it, Charsets.UTF_8) } ?: "<empty>"

        val summary = buildString {
            appendLine("Tapp Networking — Preview")
            appendLine()
            appendLine("URL:")
            appendLine(req.url)                    // <- from HttpRequest
            appendLine()
            appendLine("Headers:")
            req.headers.forEach { (k, v) -> appendLine("• $k: $v") }
            appendLine()
            appendLine("Body:")
            appendLine(bodyPreview)
        }

        tv.text = summary
    }
}
