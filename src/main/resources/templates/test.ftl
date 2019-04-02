<#import "parts/common.ftl" as common>
<#import "parts/copyright.ftl" as copyright>
<#include "parts/security.ftl">
<@common.page>
    <section id="films">
        <div>
            <form method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="text" placeholder="Введите название" name="title"/>
                <input type="number" placeholder="Введите год выпуска" name="dateProd"/>
                <input type="text" placeholder="Введите жанр" name="genre"/>
                <input type="text" placeholder="Введите описание" name="description"/>
                <input type="submit" class="films_btn" value="Добавить">
            </form>
            <form method="get" action="/test">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <input type="text" placeholder="Введите название" name="sTitle" value="${sTitle}" />
                <input type="number" placeholder="Введите год выпуска" name="sDateProd" value="${sDateProd}" />
                <input type="text" placeholder="Введите жанр" name="sGenre" value="${sGenre}"/>
                <input type="submit" class="films_btn" value="Поиск">
                <br>
                <div>Заполните одно поле. <br>
                    Оставьте поля пустыми и нажмите 'Поиск', чтобы получить весь список.</div>
            </form>
        </div>
        <div class="films_wrapper">
            <div class="films_wrapper_text">
                <h1>Список фильмов</h1>
                <h2>Список фильмов помогают найти интересное кино, которое вы ещё не видели.</h2>
            </div>
            <div class="table">
                <table border="1" width="90%">
                    <tr>
                        <div>
                            <th>Номер</th>
                            <th>Название</th>
                            <th>Год</th>
                            <th>Жанр</th>
                            <th>Краткое описание</th>
                        </div>
                    </tr>
                    <#list films?ifExists as film>
                        <table border="1" width="100%">
                            <div>
                                <th width="5%">${film.id}</th>
                                <th width="20%">${film.title}</th>
                                <th width="10%">${film.dateProd}</th>
                                <th width="20%">${film.genre}</th>
                                <th width="45%">${film.description}</th>
                            </div>
                        </table>
                    <#else>
                        <table border="1" width="100%">
                            <div>
                                <th width="100%">No products</th>
                            </div>
                        </table>
                    </#list>
                </table>
            </div>
        </div>
    </section>
</@common.page>
