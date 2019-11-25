import random

version = 0.1
baseReproductionChances = 21.0 # % chances of reproduction (100 max) One decimal allowed
baseNumberOfIndividuals = 5000 # number of individuals to start the experiment
maxReproductionFactor = 8
mutationChances = 0.1 # % chances of mutation (50% negative 50% positive)  (100 max) Two decimals allowed
maxIndividuals = 2000000
mutationAlterationFactor = 1.5 # 1 = 0% - 1%  2 = 0% - 2% ...

# open file
f = open("output.csv","w")

# write preheader info
f.write("version: %.1f;baseReproductionChances: %.3f;baseNumberOfIndividuals: %d;maxReproductionFactor: %d;mutationChances: %.3f;mutationAlterationFactor %.3f\r\n" % (version,baseReproductionChances,baseNumberOfIndividuals,maxReproductionFactor,mutationChances,mutationAlterationFactor))
# write header
f.write("generation;individuals;averageNegativeMutations;averagePositiveMutations;maxNegativeMutation;maxPositiveMutation\r\n")

# create the base set of individuals
individuals = []
for i in range(baseNumberOfIndividuals):
	individuals.append({'reproduction' : baseReproductionChances, 'negativeMutations' : 0, 'positiveMutations' : 0, 'generation' : 1})
generation = 1

while len(individuals) > 0 and len(individuals) < maxIndividuals:
	individualsCount = 0
	positiveMutationsCount = 0
	negativeMutationsCount = 0
	maxPositiveMutation = 0
	maxNegativeMutation = 0
	for individual in individuals:
		#print(individual)
		if individual['generation'] == generation:
			individualsCount += 1 # number of individuals of this generation
			positiveMutationsCount += individual['positiveMutations']
			negativeMutationsCount += individual['negativeMutations']
			if maxPositiveMutation < individual['positiveMutations']:
				maxPositiveMutation = individual['positiveMutations']
			if maxNegativeMutation < individual['negativeMutations']:
				maxNegativeMutation = individual['negativeMutations']
			if random.randint(0,1000) <= individual['reproduction']*10: # reproduction?
				#print("REPRODUCTION!")
				numberOfSons = random.randint(1,maxReproductionFactor)
				for sons in range(numberOfSons): # generates all the sons
					if random.randint(0,10000) <= mutationChances * 100: # mutation??!!
						#print("MUTATION!")
						alteration = float(random.randint(0,10) / 10.0) * mutationAlterationFactor
						if random.randint(0,1) == 0: # negative mutation
							individuals.append({'reproduction' : individual['reproduction'] - alteration, 'negativeMutations' : individual['negativeMutations'] + 1, 'positiveMutations' : individual['positiveMutations'], 'generation' : individual['generation']+1})	
						else: # positive mutation
							individuals.append({'reproduction' : individual['reproduction'] + alteration, 'negativeMutations' : individual['negativeMutations'], 'positiveMutations' : individual['positiveMutations'] + 1, 'generation' : individual['generation']+1})	
					else: # no mutation
						individuals.append({'reproduction' : individual['reproduction'], 'negativeMutations' : individual['negativeMutations'], 'positiveMutations' : individual['positiveMutations'], 'generation' : individual['generation']+1})	

	# remove last generation
	individuals = [ individual for individual in individuals if individual['generation'] > generation ]
	
	print ("generation ",generation," individuals ",individualsCount)
	f.write("%d;%d;" % (generation,individualsCount))
	# show mutations
	print("Negative mutation average: ", negativeMutationsCount / individualsCount, " Positive mutation average: ", positiveMutationsCount / individualsCount )
	f.write("%.3f;%.3f;" % (negativeMutationsCount / individualsCount,positiveMutationsCount / individualsCount))
	# max mutations
	print("Max negative mutation: ", maxNegativeMutation, " Max positive mutation: ", maxPositiveMutation)
	f.write("%d;%d\r\n" % (maxNegativeMutation,maxPositiveMutation))
	# increment generation
	generation += 1
f.close()


