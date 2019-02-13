# java-ee-jpa-series-SzN

a JPA project with the following entities:

Series
Season
Episode
Each entity should contain at least 3 attributes (id, name, title, length, releaseDate, etc), and you should connect entities together based on these relations:

1 Series has N Seasons
1 Season has N Episodes
Your implementation should also contain all of these JPA annotations: @Transient, @Enumerated, @ElementCollection.

Fill up the entities based on your liking (eg: Game of Thrones, 6-7 seasons, 10 episodes for each season) in a CommandLineRunner.
