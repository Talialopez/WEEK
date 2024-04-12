package com.example.appweek

import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.DataPoint
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class Reporte : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reporte)

        val btnDownloadPdf = findViewById<Button>(R.id.btnDownloadPdf)
        btnDownloadPdf.setOnClickListener {
            createPdf()
        }

        setupGraph()  // Asegúrate de llamar a setupGraph para configurar y mostrar el gráfico.
    }

    private fun createPdf() {
        val pdfDocument = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create()
        val page = pdfDocument.startPage(pageInfo)
        val canvas = page.canvas

        val paint = Paint()

        // Estilos de texto y barras
        val titlePaint = Paint(paint).apply {
            textSize = 36f
            color = Color.BLACK
            textAlign = Paint.Align.CENTER
        }
        val labelPaint = Paint(paint).apply {
            textSize = 22f
            color = Color.BLACK
            textAlign = Paint.Align.CENTER
        }
        val barPaint = Paint(paint).apply {
            color = Color.parseColor("#FFA500") // Color naranja
        }
        val textPaint = Paint(paint).apply {
            textSize = 16f
            color = Color.BLACK
            textAlign = Paint.Align.LEFT
        }

        // Datos ficticios para el gráfico
        val usersPerMonth = arrayOf(150, 120, 180, 160, 200, 140, 190, 210, 170, 130, 110, 160)
        val months = arrayOf("Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic")

        // Información adicional
        val maxUsers = usersPerMonth.maxOrNull() ?: 0
        val minUsers = usersPerMonth.minOrNull() ?: 0
        val averageUsers = usersPerMonth.average()
        val maxMonth = months[usersPerMonth.indexOf(maxUsers)]
        val minMonth = months[usersPerMonth.indexOf(minUsers)]
        val percentageChange = ((usersPerMonth.last() - usersPerMonth.first()).toFloat() / usersPerMonth.first() * 100)

        // Título
        canvas.drawText("Reporte de Usuarios", pageInfo.pageWidth / 2f, 100f, titlePaint)

        // Ajustar los márgenes y el espacio entre barras
        val sideMargin = 50f
        val spaceBetweenBars = 10f
        val barWidth = ((pageInfo.pageWidth - sideMargin * 2 - spaceBetweenBars * 11) / 12).toFloat()
        val maxBarHeight = (pageInfo.pageHeight / 3).toFloat()  // Un tercio de la página para la altura máxima de las barras
        val bottomOfBars = (pageInfo.pageHeight / 2).toFloat()  // La mitad de la página para el fondo de las barras
        var currentX = sideMargin.toFloat()

        usersPerMonth.forEachIndexed { index, count ->
            val barHeight = (count / maxUsers.toFloat()) * maxBarHeight
            val top = bottomOfBars - barHeight
            canvas.drawRect(currentX, top, currentX + barWidth, bottomOfBars, barPaint)
            canvas.drawText(months[index], currentX + barWidth / 2, bottomOfBars + 30f, labelPaint)
            canvas.drawText(count.toString(), currentX + barWidth / 2, top - 10f, labelPaint)
            currentX += barWidth + spaceBetweenBars
        }

        val spaceBelowBars = 80f
        // Dibuja la información estadística debajo del gráfico
        val statsStartY = bottomOfBars + 50f
        canvas.drawText("Mes con más usuarios: $maxMonth con $maxUsers usuarios", sideMargin, statsStartY, textPaint)
        canvas.drawText("Mes con menos usuarios: $minMonth con $minUsers usuarios", sideMargin, statsStartY + 20f, textPaint)
        canvas.drawText("Media de usuarios registrados: ${"%.2f".format(averageUsers)}", sideMargin, statsStartY + 40f, textPaint)
        canvas.drawText("Cambio porcentual de usuarios registrados: ${"%.2f".format(percentageChange)}%", sideMargin, statsStartY + 60f, textPaint)

        // Finaliza la página y el documento
        pdfDocument.finishPage(page)
        try {
            val filePath = File(getExternalFilesDir(null), "ReporteUsuarios2024.pdf")
            val fileOutputStream = FileOutputStream(filePath)
            pdfDocument.writeTo(fileOutputStream)
            fileOutputStream.close()
            runOnUiThread {
                Toast.makeText(this, "PDF guardado en: ${filePath.absolutePath}", Toast.LENGTH_LONG).show()
            }
        } catch (e: IOException) {
            e.printStackTrace()
            runOnUiThread {
                Toast.makeText(this, "Error al crear el PDF: ${e.localizedMessage}", Toast.LENGTH_LONG).show()
            }
        } finally {
            pdfDocument.close()
        }
    }








    private fun setupGraph() {
        val graph = findViewById<GraphView>(R.id.graph)
        val series = BarGraphSeries(arrayOf(
            DataPoint(0.0, 150.0),
            DataPoint(1.0, 120.0),
            DataPoint(2.0, 180.0),
            DataPoint(3.0, 160.0),
            DataPoint(4.0, 200.0),
            DataPoint(5.0, 140.0),
            DataPoint(6.0, 190.0),
            DataPoint(7.0, 210.0),
            DataPoint(8.0, 170.0),
            DataPoint(9.0, 130.0),
            DataPoint(10.0, 110.0),
            DataPoint(11.0, 160.0)
        ))
        series.color = android.graphics.Color.parseColor("#FFA500")  // Establecer el color de las barras a naranja.
        graph.addSeries(series)

        // Configurar el color del texto de los ejes y los valores
        graph.gridLabelRenderer.horizontalLabelsColor = android.graphics.Color.WHITE
        graph.gridLabelRenderer.verticalLabelsColor = android.graphics.Color.WHITE
        graph.gridLabelRenderer.horizontalAxisTitleColor = android.graphics.Color.WHITE
        graph.gridLabelRenderer.verticalAxisTitleColor = android.graphics.Color.WHITE
        graph.titleColor = android.graphics.Color.WHITE

        graph.gridLabelRenderer.horizontalAxisTitle = "Mes"
        graph.gridLabelRenderer.verticalAxisTitle = "Usuarios Registrados"
        graph.title = "Registro de Usuarios por Mes en 2024"

        series.isDrawValuesOnTop = true
        series.valuesOnTopColor = android.graphics.Color.WHITE
    }
}
