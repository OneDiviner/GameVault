package com.example.impl.domain.usecase

import com.example.impl.domain.model.Game
import com.example.impl.domain.repository.HomeRepository

internal class GetGamesUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(
        page: Int?,
        pageSize: Int,
        searchQuery: String?
    ): Result<List<Game>> {
        return repository.getGames(
            page = page,
            pageSize = pageSize,
            searchQuery = searchQuery
        )
        //delay(700)
        /*return Result.success(
            persistentListOf(
                Game(
                    id = 1,
                    name = "The Witcher 3",
                    backgroundImage = "https://media.rawg.io/media/games/618/618c2031a07bbff6b4f611f10b6bcdbc.jpg",
                    metacritic = "92",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 2,
                    name = "Red Dead Redemption 2",
                    backgroundImage = "https://media.rawg.io/media/games/511/5118aff5091cb3efec399c808f8c598f.jpg",
                    metacritic = "97",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 3,
                    name = "Portal 2",
                    backgroundImage = "https://media.rawg.io/media/games/2ba/2bac0e87cf45e5b508f227d281c9252a.jpg",
                    metacritic = "95",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 4,
                    name = "Terraria",
                    backgroundImage = "https://media.rawg.io/media/games/f46/f466571d536f2e3ea9e815ad17177501.jpg",
                    metacritic = "86",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 5,
                    name = "God of War",
                    backgroundImage = "https://media.rawg.io/media/games/4be/4be6a6ad0364751a96229c56bf69be73.jpg",
                    metacritic = "94",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 6,
                    name = "Cyberpunk 2077",
                    backgroundImage = "https://media.rawg.io/media/games/26d/26d4437715bee60138dab4a7c8c59c92.jpg",
                    metacritic = "86",
                    platforms = listOf(
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                    )
                ),
                Game(
                    id = 7,
                    name = "Elden Ring",
                    backgroundImage = "https://media.rawg.io/media/games/b29/b294fdd866dcdb643e7bab370a552855.jpg",
                    metacritic = "96",
                    platforms = listOf(
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 8,
                    name = "Half-Life 2",
                    backgroundImage = "https://media.rawg.io/media/games/b8c/b8c243eaa0fbac8115e0cdccac3f91dc.jpg",
                    metacritic = "96",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                    )
                ),
                Game(
                    id = 9,
                    name = "Dark Souls 3",
                    backgroundImage = "https://media.rawg.io/media/games/da1/da1b267764d77221f07a4386b6548e5a.jpg",
                    metacritic = "89",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 10,
                    name = "Sekiro",
                    backgroundImage = "https://media.rawg.io/media/games/67f/67f62d1f062a6164f57575e0604ee9f6.jpg",
                    metacritic = "90",
                    platforms = listOf(
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 11,
                    name = "Grand Theft Auto V",
                    backgroundImage = "https://media.rawg.io/media/games/20a/20aa03a10cda45239fe22d035c0ebe64.jpg",
                    metacritic = "97",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 3,
                            name = "IOS"
                        ),
                    )
                ),
                Game(
                    id = 12,
                    name = "Batman Arkham City",
                    backgroundImage = "https://media.rawg.io/media/games/9f1/9f18957d6dc4a58cd84b946571d35b74.jpg",
                    metacritic = "96",
                    platforms = listOf(
                        Platform(
                            id = 0,
                            name = "PC"
                        ),
                        Platform(
                            id = 1,
                            name = "PS"
                        ),
                        Platform(
                            id = 2,
                            name = "XBOX"
                        ),
                    )
                )
            )
        )
        // TODO: return repository.getGames()*/
    }
}