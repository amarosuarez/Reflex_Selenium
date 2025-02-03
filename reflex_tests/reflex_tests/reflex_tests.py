import reflex as rx

from .pages.buscadores import buscadores
from .pages.redes_sociales import redesSociales

def index() -> rx.Component:
    return rx.vstack(
        rx.heading("Inicio"),
        rx.list(
            rx.list_item(rx.link("Buscadores", href="/buscadores", id="buscadores")),
            rx.list_item(rx.link("Redes sociales", href="/redes-sociales", id="redes-sociales")),
        ),
    )

app = rx.App()
app.add_page(index, route="/")
app.add_page(buscadores, route="/buscadores")
app.add_page(redesSociales, route="/redes-sociales")