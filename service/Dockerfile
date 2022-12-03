FROM mcr.microsoft.com/dotnet/aspnet:7.0 AS base
WORKDIR /app
EXPOSE 80
EXPOSE 443

FROM mcr.microsoft.com/dotnet/sdk:7.0 AS build
WORKDIR /src
COPY ["space.linuxct.SUIVT.Api.csproj", "./"]
RUN dotnet restore "space.linuxct.SUIVT.Api.csproj"
COPY . .
WORKDIR "/src/"
RUN dotnet build "space.linuxct.SUIVT.Api.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "space.linuxct.SUIVT.Api.csproj" -c Release -o /app/publish

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "space.linuxct.SUIVT.Api.dll"]
