import reflex as rx

from reflex_tests.routes import Ruta

@rx.page(
    route=Ruta.BUSCADORES.value,
    title = "Buscadores",
    description="Página de buscadores"
)

def buscadores() -> rx.Component:
    return rx.vstack(
        rx.heading("Página de buscadores"),
        rx.list(
            rx.list_item(rx.link("Google", href="https://www.google.com", id="google", is_external=True)),
            rx.list_item(rx.link("Bing", href="https://www.bing.com", id="bing", is_external=True)),
            rx.list_item(rx.link("Baidu", href="https://www.baidu.com", id="baidu", is_external=True)),
        ),
        rx.button(
            rx.link(
                "Volver",
                href="/"
            )
        )
    )

# app = rx.App()
