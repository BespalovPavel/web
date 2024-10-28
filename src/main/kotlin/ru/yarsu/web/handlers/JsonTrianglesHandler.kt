package ru.yarsu.web.handlers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.http4k.core.*
import org.http4k.format.Jackson.auto
import org.http4k.template.PebbleTemplates
import ru.yarsu.web.data.Triangles
import ru.yarsu.web.models.JsonTrianglesVM
import ru.yarsu.web.models.PebbleVM
import ru.yarsu.web.models.TrianglesVM

class JsonTrianglesHandler(val triangles: Triangles): HttpHandler {
    override fun invoke(request: Request): Response {
        val renderer = PebbleTemplates().CachingClasspath()

//        val obj = jacksonObjectMapper()
//        val jsonTraingles = obj.writerWithDefaultPrettyPrinter().writeValueAsString(triangles)
//        val viewModel = JsonTrianglesVM(jsonTraingles)
//        val htmlDocument = renderer(viewModel)
//        return Response(Status.OK).body(htmlDocument)

        val jsonLens = Body.auto<Triangles>().toLens()
        return Response(Status.OK).with(jsonLens of triangles)
    }
}
