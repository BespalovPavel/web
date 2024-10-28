package ru.yarsu.web.models

import org.http4k.template.ViewModel
import ru.yarsu.web.data.Triangle
import ru.yarsu.web.data.Triangles

class CurTriangleVM(val triangle: Triangle?) : ViewModel
