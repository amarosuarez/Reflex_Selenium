import reflex as rx

from reflex_tests.routes import Ruta

@rx.page(
    route=Ruta.INDEX.value,
    title = "Index",
    description="Página de inicio"
)
def index() -> rx.Component:
    return rx.vstack(
        rx.heading("Inicio"),
        rx.list(
            rx.list_item(rx.link("Buscadores", href="/buscadores", id="buscadores")),
            rx.list_item(rx.link("Redes sociales", href="/redes-sociales", id="redes-sociales")),
        ),
    )

# app = rx.App()