package com.example.projetnav.ui.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetnav.R
import com.example.projetnav.ui.series.episodes.Episode
import com.example.projetnav.ui.series.personnages.Personnage

class FragmentListSeries : Fragment() {
    private lateinit var listSeriesViewModel: ListSeriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_series, container, false)

        listSeriesViewModel = ViewModelProvider(this).get(ListSeriesViewModel::class.java)

        val series = listOf(
            Serie(
                title = "Marvel's Agents of SHIELD",
                imageResId = R.drawable.agents_of_shield,
                studio = "Marvel",
                numberOfEpisodes = 136,
                year = 2013,
                story = "Après de longs mois de repos à la suite de sa blessure infligée " +
                        "par le légendaire dieu Loki pendant l'invasion de New York, l'agent " +
                        "Phil Coulson réintègre le SHIELD, une organisation internationale qui " +
                        "enquête sur les phénomènes paranormaux et défend la Terre des menaces " +
                        "terroristes ou d’invasions extraterrestre.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "Arrow",
                imageResId = R.drawable.arrow,
                studio = "DC Comics",
                numberOfEpisodes = 170,
                year = 2012,
                story = "Après un violent naufrage, le jeune milliardaire et playboy Oliver Queen, " +
                        "porté disparu et présumé mort depuis cinq ans, est découvert vivant sur une " +
                        "île isolée dans la mer de Chine. Quand il rentre chez lui, à Starling City, " +
                        "sa mère dévouée Moira, sa sœur bien-aimée Thea et son meilleur ami Tommy " +
                        "l'accueillent chez lui, mais ils sentent qu'Oliver a changé.\n" +
                        "\n" +
                        "Alors qu'Oliver cache la vérité sur l'homme qu'il est devenu, il cherche désespérément " +
                        "à faire amende honorable pour les actions passées de son père grâce à une liste " +
                        "de noms d'individus ayant, selon les propres mots d'Oliver, « trahi leur ville », " +
                        "qu'il cherche à faire emprisonner.\n" +
                        "\n" +
                        "Il devient alors un justicier qui va réparer les torts de sa famille, lutter contre les " +
                        "« maux de la société » et redonner à la ville de Starling son ancienne gloire",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "House of the Dragon",
                imageResId = R.drawable.house_of_the_dragon,
                studio = "HBO",
                numberOfEpisodes = 10,
                year = 2022,
                story = "La série se déroule 172 ans avant la naissance de Daenerys Targaryen et raconte " +
                        "les événements qui ont provoqué une guerre civile appelée La Danse des Dragons " +
                        "(Dance of the Dragons), qui conduit à la perte des dragons et au début de la chute " +
                        "de la Maison Targaryen.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "Game of Thrones",
                imageResId = R.drawable.game_of_thrones,
                studio = "HBO",
                numberOfEpisodes = 73,
                year = 2011,
                story = "Sur le continent de Westeros, le roi Robert Baratheon gouverne le Royaume des Sept Couronnes " +
                        "depuis plus de dix-sept ans, à la suite de la rébellion qu'il a menée contre le « roi fou » " +
                        "Aerys II Targaryen. Jon Arryn, époux de la sœur de Lady Catelyn Stark, Lady Arryn, son guide " +
                        "et principal conseiller, vient de s'éteindre, et le roi part alors dans le nord du royaume demander " +
                        "à son vieil ami Eddard « Ned » Stark de remplacer leur regretté mentor au poste de Main du roi. " +
                        "Ned, seigneur suzerain du nord depuis Winterfell et de la maison Stark, est peu désireux de quitter " +
                        "ses terres. Mais il accepte à contrecœur de partir pour la capitale Port-Réal avec ses deux filles, " +
                        "Sansa et Arya. Juste avant leur départ pour le sud, Bran, l'un des jeunes fils d'Eddard, est poussé " +
                        "de l'une des tours de Winterfell après avoir été témoin de la liaison incestueuse entre la reine " +
                        "Cersei Baratheon et son frère jumeau, Jaime Lannister. Leur frère, Tyrion Lannister, surnommé " +
                        "« le gnome », est alors accusé du crime par Lady Catelyn Stark.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "The Boys",
                imageResId = R.drawable.the_boys,
                studio = "Amazon Studios",
                numberOfEpisodes = 24,
                year = 2019,
                story = "Hughie Campbell rejoint les « Boys » peu après qu'A-Train, membre du groupe de super-héros " +
                        "« les Sept », a accidentellement tué sa petite amie Robin. De son côté, la jeune héroïne Annie " +
                        "January, surnommée Starlight, rejoint les Sept. Venant d'une petite ville, la jeune femme est pleine " +
                        "d'espoir mais va devoir faire face à la terrible vérité sur ceux qu'elle admirait tant. Stella va " +
                        "notamment déchanter en côtoyant le leader des Sept, Homelander. Les autres membres des Sept sont la " +
                        "désillusionnée Reine Maeve, le toxicomane A-Train, le déséquilibré The Deep, l'invisible Translucide " +
                        "et le mystérieux Black Noir. Plus tard, la suprémaciste Stormfront rejoindra le groupe et en deviendra " +
                        "un membre essentiel. Madelyn Stillwell, cadre de Vought, supervise les Sept.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "The Witcher",
                imageResId = R.drawable.the_witcher,
                studio = "Netflix",
                numberOfEpisodes = 24,
                year = 2019,
                story = "L'histoire commence avec Geralt de Riv, la princesse héritière Cirilla de Cintra et la " +
                        "sorcière quart-elfe Yennefer de Vengerberg à différents moments, explorant les événements formateurs " +
                        "qui façonnent leurs personnages tout au long de la première saison, avant de finalement fusionner en " +
                        "une seule chronologie.\n" +
                        "\n" +
                        "Geralt et Ciri sont liés par le destin avant sa naissance lorsqu'il l'a sans le savoir exigée en " +
                        "récompense de ses services en invoquant « la loi de la surprise ». Après que les deux se soient " +
                        "finalement rencontrés, Geralt devient le protecteur de la princesse et doit l'aider et lutter contre " +
                        "ses différents poursuivants pour empêcher son sang ancien et sa puissante magie d'être utilisés à des " +
                        "fins malveillantes et assurer la sécurité de Ciri et de leur monde.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "Better Call Saul",
                imageResId = R.drawable.better_call_saul,
                studio = "AMC",
                numberOfEpisodes = 63,
                year = 2015,
                story = "Six ans avant de croiser le chemin de Walter White et de Jesse Pinkman, James McGill, dit « Jimmy » " +
                        "(Bob Odenkirk), est un avocat qui peine à faire décoller sa carrière, à Albuquerque, au " +
                        "Nouveau-Mexique. Devenu avocat sous l'influence de son frère Charles McGill (Michael McKean), dit " +
                        "« Chuck », lui-même avocat renommé et partenaire cofondateur du cabinet Hamlin, Hamlin et McGill (HHM) " +
                        "au côté de Howard Hamlin (Patrick Fabian), Jimmy tente de lui prouver sa valeur ainsi qu'auprès de " +
                        "Kim Wexler (Rhea Seehorn), sa compagne qu'il a rencontrée du temps où il travaillait au service du " +
                        "courrier de HHM.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "Breaking Bad",
                imageResId = R.drawable.breaking_bad,
                studio = "AMC",
                numberOfEpisodes = 63,
                year = 2008,
                story = "Walter « Walt » White est professeur de chimie dans une école secondaire. Il vit à Albuquerque, " +
                        "au Nouveau-Mexique, avec son fils handicapé moteur et son épouse enceinte. Le lendemain de son " +
                        "cinquantième anniversaire, on lui diagnostique un cancer du poumon en phase terminale avec une " +
                        "espérance de vie estimée à deux ans. Tout s'effondre pour lui. Il décide alors de mettre en place un " +
                        "laboratoire et un trafic de méthamphétamine pour assurer un avenir financier confortable à sa famille " +
                        "après sa mort, en s'associant à Jesse Pinkman, un de ses anciens élèves devenu petit trafiquant.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            ),
            Serie(
                title = "The Flash",
                imageResId = R.drawable.flash,
                studio = "The CW",
                numberOfEpisodes = 184,
                year = 2015,
                story = "Barry Allen est un jeune scientifique travaillant pour la police de Central City. Une nuit, lorsqu'il " +
                        "avait 11 ans, il a été témoin d'un phénomène inexplicable : sa mère, prise au piège dans un tourbillon " +
                        "d'éclairs, a été assassinée. Son père a été accusé du meurtre et il purge une peine pour un crime qu'il " +
                        "n'a pas commis.\n" +
                        "\n" +
                        "Alors adulte, Barry est frappé par un éclair provoqué par l'explosion d'un accélérateur de particules " +
                        "dans les laboratoires S.T.A.R Labs de Harrison Wells, et sombre dans le coma pendant neuf mois. À son " +
                        "réveil, il découvre qu'il peut courir à des vitesses surhumaines et guérir de façon accélérée. Pour le " +
                        "monde entier, Barry est un scientifique qui travaille pour la police, mais secrètement, avec l'aide de " +
                        "ses nouveaux amis de S.T.A.R Labs, il utilise sa vitesse pour combattre le crime et trouver d'autres " +
                        "personnes comme lui, des méta-humains. Toutefois, son but premier est de découvrir qui a tué sa mère et " +
                        "faire réhabiliter son père.",
                personnages = listOf(
                    Personnage("Personnage 1", "Rôle 1", R.drawable.astronaut),
                    Personnage("Personnage 2", "Rôle 2", R.drawable.astronaut),
                    // ... Ajoutez d'autres personnages selon vos besoins
                ),
                episodes = listOf(
                    Episode("Épisode 1", "Description de l'épisode 1", 1, "01/01/2022"),
                    Episode("Épisode 2", "Description de l'épisode 2", 2, "02/01/2022"),
                    // ... Ajoutez d'autres épisodes selon vos besoins
                )
            )
        )

        listSeriesViewModel.series = series

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_series)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ListSerieAdapter(listSeriesViewModel.series)

        return view
    }
}
