package ru.yarsu.web.handlers

import org.http4k.core.*
import org.http4k.routing.path
import org.http4k.template.PebbleTemplates
import ru.yarsu.web.data.Triangles
import ru.yarsu.web.models.CurTriangleVM
import ru.yarsu.web.models.PebbleVM
import ru.yarsu.web.models.TrianglesVM

class CurTriangleHandler(val triangles: Triangles): HttpHandler {
    override fun invoke(request: Request): Response {
        val renderer = PebbleTemplates().CachingClasspath()

        val id = request.path("id")
        val viewModel = CurTriangleVM(triangles.triangles.find { it.id == id })
        val htmlDocument = renderer(viewModel)
        return Response(Status.OK).body(htmlDocument)
    }
}
