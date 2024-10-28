package ru.yarsu.web

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.http4k.core.Method
import org.http4k.routing.bind
import org.http4k.routing.routes
import ru.yarsu.web.data.Triangles
import ru.yarsu.web.handlers.CurTriangleHandler
import ru.yarsu.web.handlers.JsonTrianglesHandler
import ru.yarsu.web.handlers.TrianglesHandler
import java.io.File

val obj = jacksonObjectMapper()

var trianglesData: Triangles = obj.readValue<Triangles>(File("data/triangles.json"))
var sortedTrianglesData = Triangles(trianglesData.triangles.sortedBy { it.sideA + it.sideB + it.sideC })

val router = routes(
    "/" bind Method.GET to TrianglesHandler(sortedTrianglesData),
    "/triangles/{id}" bind Method.GET to CurTriangleHandler(sortedTrianglesData),
    "/trianglesJson" bind Method.GET to JsonTrianglesHandler(sortedTrianglesData)
)
