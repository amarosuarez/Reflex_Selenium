import reflex as rx

from reflex_tests import reflex_tests

def redesSociales() -> rx.Component:
    return rx.vstack(
        rx.heading("Página de Redes Sociales"),
        rx.list(
            rx.list_item(rx.link("Instagram", href="https://www.instagram.com", id="instagram", is_external=True)),
            rx.list_item(rx.link("TikTok", href="https://www.tiktok.com", id="tiktok", is_external=True)),
            rx.list_item(rx.link("Facebook", href="https://www.facebook.com", id="facebook", is_external=True)),
        ),
        rx.button(
            rx.link(
                "Volver",
                href="/"
            )
        )
    )

app = rx.App()
app.add_page(reflex_tests, route="/")
