package ru.yarsu.web.handlers

import org.http4k.core.*
import org.http4k.template.PebbleTemplates
import ru.yarsu.web.data.Triangles
import ru.yarsu.web.models.PebbleVM
import ru.yarsu.web.models.TrianglesVM

class TrianglesHandler(val triangles: Triangles): HttpHandler {
    override fun invoke(request: Request): Response {
        val renderer = PebbleTemplates().CachingClasspath()
        val viewModel = TrianglesVM(triangles)
        val htmlDocument = renderer(viewModel)
        return Response(Status.OK).body(htmlDocument)
    }
}
